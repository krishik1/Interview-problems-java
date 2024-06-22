package Greedy;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class URIPROB {
	public static void main(String[] args) {
		String urlString = "http://foobar/somepage?arg1=ab1o0s&arg2=ab123";

        try {
            // Parse the URL
            URI uri = new URI(urlString);

            // Extract components
            String scheme = uri.getScheme();
            String host = uri.getHost();
            int port = uri.getPort();
            String path = uri.getPath();
            String query = uri.getQuery();

            // Print components
            System.out.println("Scheme: " + scheme);
            System.out.println("Host: " + host);
            System.out.println("Port: " + port);
            System.out.println("Path: " + path);
            System.out.println("Query: " + query);
            
            
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

	}
	
//	public static void main(String[] args) {
//		List<String> disallowedParams = Arrays.asList("arg1", "arg2");
//
//        String urlString = "http://foobar/somepage?arg1=ab1o0s&arg2=ab123&arg3=value";
//
//        try {
//            // Parse the URL
//            URI uri = new URI(urlString);
//
//            // Extract query parameters
//            String query = uri.getQuery();
//
//            // Check if any disallowed parameters are present
//            if (query != null) {
//                String[] queryParams = query.split("&");
//
//                for (String param : queryParams) {
//                    String paramName = param.split("=")[0];
//                    if (disallowedParams.contains(paramName)) {
//                        System.out.println("Disallowed parameter found: " + paramName);
//                        // You can take appropriate action here, e.g., return an error response.
//                    }
//                }
//            }
//
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//
//	}



}
