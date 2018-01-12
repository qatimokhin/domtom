import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.apache.http.client.HttpClient;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.*;

/**
 * Created by igortimokhin on 1/11/18.
 */
public class JavaTest {
    List<String> myArrayList = new ArrayList<String>();
    private HttpClient httpClient;

    @Before
    public void setup() {
        myArrayList.add("Chrome");
        myArrayList.add("FireFox");
        myArrayList.add("IE");
        myArrayList.add("Safari");
        myArrayList.add("Chrome");

    }

    /**
     * Testing general Java String function knowledge
     */

    @Test
    public void funWithJavaStrings() {

        System.out.println("----------FunWithJavaStrings-------------");

        String companyName = "Dom & Tom Inc.";
        // Assert that the word 'Dom' is present in companyName string
        assertThat(companyName, containsString("Dom"));

        String name1 = "Netflix";
        String name2 = "NETFLIX";
        // Assert that name1 equals name2 regardless of case and leading/trailing spaces
        assertThat(name1, equalToIgnoringCase(name2));
        assertThat(name1, equalToIgnoringWhiteSpace(name2));


        String intValue1 = "100";
        String intValue2 = "20";
        // Convert the above 2 strings to integer values and display the sum
        System.out.println(Integer.parseInt(intValue1) + Integer.parseInt(intValue2));
    }

    /**
     * Testing knowledge of java Lists. The list 'myArrayList' has already been
     * created and populated in @before method. Follow steps outlined below.
     */

    @Test
    public void funWithArrayLists() {

        System.out.println("----------FunWithArrayLists-------------");

        // Step 1 display the number of elements in myArrayList
        System.out.println("My ArrayList Size ==> " + myArrayList.size());


        // Step 2 using enhanced for-loop loop thru myArrayList and display all values to console

        for (String string : myArrayList)

            System.out.println(string);


        // Step 3 Display the 3rd element in myArrayList
        System.out.println(myArrayList.get(2));

        /**
         * Step 4 Loop thru myArrayList to determine if any elements value = 'IE'
         * if yes, display 'IE found @ index' and the index number in the  console then exit the loop
         */
        for (String string : myArrayList)
            if (string == "IE") {
                System.out.println("IE found @ index ==>" + myArrayList.indexOf(string));
            }
        ;


        /**
         * Step 5 Loop thru myArrayList to determine if any list elements value = 'Opera'
         * if not , display 'Opera not found'
         */
        for (String string : myArrayList)
            if (string != "Opera") {
                System.out.println("Opera not found");
            }
        ;

    }

    /**
     * Testing knowledge of java HashMaps Follow steps outlined below
     */

    @Test
    public void funWithHashMaps() {

        System.out.println("----------FunWithHashMaps-------------");

        HashMap<Integer, String> myHashMap = new HashMap<Integer, String>();


		/*
		 * Step 1 Load the following into ' myHashMap'
		 *
		 * Key: = 1 Value: = "XP"
		 * Key: = 2 Value: = "WIN7"
		 * Key: = 3 Value: = "WIN8"
		 */
        myHashMap.put(1, "XP");
        myHashMap.put(2, "WIN7");
        myHashMap.put(3, "WIN8");

        // Step 2 Display to console the value associated with key 2

        System.out.println("The value associated with key #2 ==> " + myHashMap.get(2));


        // Step 3 Display the number of elements in myHashMap

        System.out.println("HashMap size ==> " + myHashMap.size());

        // Step 4 Remove the last element in myHashMap and display the number of elements in myHashMap
        myHashMap.remove(3);
        System.out.println(myHashMap.values());

    }

    /**
     * Testing knowledge of calling and processing a RESTFUL WebService call using Apache HttpClient
     * Follow the steps outlined below
     *
     * @throws IOException
     * @throws ClientProtocolException
     */


    @Test
    public void funWithWebServices() throws IOException {

        System.out.println("----------FunWithWebServices-------------");

        String webServiceUrl = "http://api.geonames.org/cities?north=44.1&south=-9.9&east=-22.4&west=55.2&username=demo";

        //Step 1 Create instance of httpClient

        httpClient = HttpClientBuilder.create().build();

        // Step 2 Create the Get Request, call it myGetRequest using the HttpGet
        // class and webServiceUrl
        // Step 3 Using the httpClient object created in step 1 execute
        // myGetRequest and save the HttpResponse to myHttpResponse

        HttpResponse myHttpResponse = httpClient.execute(new HttpGet(webServiceUrl));

        // Step 4 Using myHttpResponse display the status code and ReasonPhrase to console

        int status_code = myHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code: " + status_code);
        String reason_frase = myHttpResponse.getStatusLine().getReasonPhrase();
        System.out.println("Reason phrase :" + reason_frase);


        /*******EXTRA CREDIT ******
         * Process the myHttpResponse and display the JSON to the console
         * ...hint the response content is returned in myHttpResponse.getEntity().getContent()
         * use BufferedReader
         */
        String body = EntityUtils.toString(myHttpResponse.getEntity());
        System.out.println(body);


    }

    /**
     * Testing knowledge of java HashSets Follow steps outlined below
     */
    @Test
    public void funWithHashSets() {

        // * Step 1 Create a HashSet of String objects called myHashSet
        Set<String> myHashSet = new HashSet<String>();

		/*
		 * Step 2 add the following String objects to myHashSet "XP" "WIN7"
		 * "WIN8" "Safari" "XP"
		 */
        myHashSet.add("XP");
        myHashSet.add("WIN7");
        myHashSet.add("WIN8");
        myHashSet.add("Safari");
        myHashSet.add("XP");

		/*
		 * Step 3 Display to console all the values of myHashSet ... hint use iterator
		 */
        for (String str : myHashSet)
            System.out.println(str);

        // Step 4 Remove from myHashSet where String = 'XP"
        myHashSet.remove("XP");
        // Step 5 Display to console the number of elements in myHashSet

        System.out.println("Set Size ==> " + myHashSet.size());

    }
}
