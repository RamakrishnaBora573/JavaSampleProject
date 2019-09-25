package test;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test1 {
	
	@Test
    public void GetSXEDEVDetails()
    {     
          RestAssured.baseURI = "";

          RequestSpecification httpRequest = RestAssured.given().accept("application/json").contentType("application/json").header("Token", "3pNk/UvVMdw/rcv2k7oC5d270NoWYj81ODvmmuaQxAB7sC69LGEFUi7LLlBIta7UFsKngcVUBe99N5xvxYKnTjrd9zsWAkTDy0MS4yeNylQJtjMhswQ4K/N6g88d0wwhOwTAMQilODdXfqvOqdX/4b7QnjlDO3YoQfI5sRcj9LvkEDOME+1sYgmNcADsnEI4LPYb8CkssW0CQShgU3v4TA7E7R4aaZlLxn5MOQXL6TyVkGeJngZqaOusdIIw5H8KQJG4g7t9yPRzSE6JB/whWmRWMANmr+5HuTDHM/m3YiixQkM2ont1dlifz6mnUPrcjJM2cr7TgUOzxXTPO30gWrC/ag2FBy2iAz9JCGuOLXMplh7im5d9N3phFFcpVFAl5+qBi6TRQa+Rzj7ub5VCilccOF6gYIcD8AJFFZJfiqfJ+B0i4GSBKp/xaNw+hWyS38Aq1wj2COs1/8mpM8HnpdVdYngvTkJo6lGgh6HZ37Nu5ueYSoJmwUpsJman9O8/Rsi+oIkSHQVfDECYlobD6qW9RfS9XthP/IRsMWs+Df44Qe6BfymZiZiunD+5gGUGXhqV40NjnYs0VNMJPKkoCVQW4eOBZI4ChDNOVzUTaVB+WACXPNoBmpb+tUNBXcj52JQ3jJTSQNUxMRqdbgId0NdNI7V80624ZiHY7+Ubt+GqJyx7wHYdE8Y+L9i/+t+Fy+f7UYRLyrp/ZEogp3lGeqUBBrpWSimUKRYusBOt5eCgwz9rW//+tuLPL6A05XZSJpWMzdrLeOk7CVji4YXujpfYaQTdQwyeNiJjdz11bTM=");
          
          //GET to get customer,group, vendor details 
          Response response = httpRequest.request(Method.GET, "http://uscswdev01.infor.com/SxeH5/api/ar/arsc/getbypk?cono=1000&custno=101");
          String CustomerBody = response.getBody().asString();
          System.out.println("Response Body for Customer is =>  " + CustomerBody);
    }
          


}
