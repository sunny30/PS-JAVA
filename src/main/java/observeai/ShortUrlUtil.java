package observeai;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShortUrlUtil {

    private static final String TINY_URL_PREFIX = "tinyurl.com" ;
    private static Map<String, String> metaStore = new HashMap<String, String>();

    private static Set<String> userDB = new HashSet<String>() ;


    private static String createKey(String url, String clientId) {
        return url.toLowerCase() + "||" + clientId.toLowerCase();
    }

    private static String createPublicURL(String url,String clientId){
        String publicURL = String.format("%s/%s",url.toLowerCase(),clientId.toLowerCase()) ;
        return publicURL ;
    }

    private static String createShortURL(String url) throws NoSuchAlgorithmException {

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(url.toLowerCase().getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            String output = String.format("%s/%s",TINY_URL_PREFIX,hashtext) ;
            return output;

        } catch (NoSuchAlgorithmException e) {

            throw e;
        }


    }

    private static String getNeatURL(String url){
        String neatURL = url.replaceFirst("^(http[s]?://www\\.|http[s]?://|www\\.)","") ;
        return String.format("http://www.%s",neatURL) ;
    }

    private static boolean isValidURL(String url){

        String regex = "((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)";

        String regex1 = "(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)";

        Pattern p1 = Pattern.compile(regex1) ;
        Matcher m1 = p1.matcher(url) ;


        Pattern p = Pattern.compile(regex);
        if (url == null) {
            return false;
        }
        Matcher m = p.matcher(url);
        return m.matches()||m1.matches();
    }




    public static String getShortenedURL(String url, String clientId) throws IllegalArgumentException,NoSuchAlgorithmException {

        url = getNeatURL(url.toLowerCase()) ;

        if(!isValidURL(url))
            throw new IllegalArgumentException("url is not Valid") ;
        if(!userDB.contains(clientId)){
            throw new IllegalArgumentException("Client is not registered with the system") ;
        }




        String metaStoreKey = createKey(url,clientId);
        if(metaStore.containsKey(metaStoreKey)){
            return metaStore.get(metaStoreKey) ;
        }else{
            String urlToEncrypt = createPublicURL(url,clientId) ;
            String encryptedURL = createShortURL(urlToEncrypt) ;
            metaStore.put(metaStoreKey,encryptedURL) ;
            return encryptedURL ;
        }



    }


    public static void main(String[] args) {

        try {
            userDB.add("1");
            userDB.add("2");
            userDB.add("12");

            String o0 = getShortenedURL("google.com", "2");
            String o1 = getShortenedURL("www.google.com", "2");
            String o2 = getShortenedURL("http://www.google.com","2") ;
            String o3 = getShortenedURL("https://www.google.com","2") ;
            System.out.println(o0);
            System.out.println(o1);
            System.out.println(o2);
            System.out.println(o3);

            String o00 = getShortenedURL("google.com", "1");
            String o10 = getShortenedURL("www.google.com", "1");
            String o20 = getShortenedURL("http://www.google.com","1") ;
            String o30 = getShortenedURL("https://www.google.com","1") ;

            System.out.println(o00);
            System.out.println(o10);
            System.out.println(o20);
            System.out.println(o30);

            getShortenedURL("www.google.com","1") ;
            //getShortenedURL("www.go ogle.com","3") ;

            getShortenedURL("www.GOOGLE.COM","1") ;
            getShortenedURL("www.go ogle.com","3") ;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e) ;
        }

    }

    //App node agent -cache (valid/invalid response set)—return response invalidate cache synchronously/ asynchronously 
}
