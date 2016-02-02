<%-- 
    Document   : hw2part5
    Created on : Jan 31, 2016, 3:38:19 PM
    Author     : kym-1992
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="index.css">
        <title>HW2 PART5</title>
    </head>
    <body>
        <%
            if("POST".equalsIgnoreCase(request.getMethod())){
                response.setContentType("text/html");

                PrintWriter output = response.getWriter();
                output.println("<!doctype html><HTML>");
                output.println("<head>");
                output.println("<title>Part6 Report</title>");
                output.println("</head>");
                output.println("<body bgcolor='pink'>");

                output.println("<UL>");        

                output.println("<LI>Officeuse: " + request.getParameter("officeuse") + "</LI>");
                String [] addresschanged = request.getParameterValues("addresschanged");
                if(addresschanged!=null){
                    output.println("<LI>Check here if this is a new address: " + addresschanged[0] + "</LI>");
                }
                output.println("<LI>Name: " + request.getParameter("name") + "</LI>");
                output.println("<LI>Address: " + request.getParameter("address") + "</LI>");
                output.println("<LI>City/State/Zip: " + request.getParameter("CityStateZip") + "</LI>");
                output.println("<LI>Phone: " + request.getParameter("phone") + "</LI>");
                output.println("<LI>Email: " + request.getParameter("Email") + "</LI>");
                output.println("<LI>Account Number: " + request.getParameter("AccountNumber") + "</LI>");
                output.println("<LI>Pet Name: " + request.getParameter("petName") + "</LI>");        
                output.println("<LI>Breed: " + request.getParameter("Breed") + "</LI>");
                output.println("<LI>Age: " + request.getParameter("age") + "</LI>"); 
                output.println("<LI>Gender: " + request.getParameter("Gender") + "</LI>");    
                output.println("<LI>Occurrence/Diagnosis: " + request.getParameter("Occurrence/Diagnosis") + "</LI>");
                String [] Related = request.getParameterValues("Related");
                if(Related!=null){
                    for(String s: Related){
                        output.println("<LI>This claim is related to: " + s + "</LI>");
                    }
                }
                String [] future = request.getParameterValues("future");
                if(future!=null){    
                    output.println("<LI>Is this claim an estimate for future treatment?" + future[0] + "</LI>"); 
                }
                output.println("<LI>TotalAmount: " + request.getParameter("totalAmount") + "</LI>");
                output.println("<LI>FirstDate: " + request.getParameter("firstDate") + "</LI>");
                String [] payment = request.getParameterValues("payment");
                if(payment!=null){
                    output.println("<LI>Send payment to:" + payment[0] + "</LI>");  
                }
                output.println("<LI>Veterinarian: " + request.getParameter("Veterinarian") + "</LI>");
                output.println("<LI>Clinic Name: " + request.getParameter("ClinicName") + "</LI>");    
                output.println("<LI>Clinic Phone: " + request.getParameter("clinicPhone") + "</LI>");
                output.println("<LI>Clinic Fax: " + request.getParameter("ClinicFax") + "</LI>"); 
                String [] otherVeterinarian = request.getParameterValues("otherVeterinarian");
                if(otherVeterinarian!=null){
                    output.println("<LI>Did any other veterinarian treat your pet?" + otherVeterinarian[0] + "</LI>");  
                }
                String [] newCondition = request.getParameterValues("newCondition");
                if(newCondition!=null){
                    output.println("<LI>Is this a new condition?" + newCondition[0] + "</LI>");   
                }
                output.println("<LI>Signature of Pet Owner: " + request.getParameter("signature") + "</LI>");
                output.println("<LI>Signature Date: " + request.getParameter("signatureDate") + "</LI>");
                output.println("</UL>");
                output.println("</body></html>");
                output.close();           

            }
            else{                
        %>
        <div>
        <form action="hw2part5.jsp" method="post">
        <div class="default">
          <table style="float:center" border="0">
            <tr>
              <td><h1>ASPCA Pet Insurance</h1></td>
              <td><textarea style="overflow:auto;resize:none" rows="5" cols="20" name="officeuse">For office use only</textarea></td>
              <td><h1>HAVE A QUESTION? Call us at 1-866-204-6764</h1></td>
            </tr>

          </table>
        </div>
        <div class="defaultGrey">
          <h2>Claim Form <i>PLEASE INCLUDE YOUR PET'S MEDICAL RECORDS TO HELP EXPEDITE PROCESSING.</i></h2>
        </div>

        <div class="noBorder">
          <p class="regular"><u>1. General Information <i>Please fill out this form completely. Incomplete forms will delay processing.</i></u></p>
        </div>

        <div class="noBorder">
          <div class="leftright">
            <div class="leftBorder" style="background-color: grey">
              <h3>Your Information&nbsp&nbsp&nbsp<input type="checkbox" name="addresschanged" value="Yes"><i>Check here if this is a new address</i></h3>
            </div>
            <div style="text-align: left">
              <h3>Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="name" size="40"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Address:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="address" size="60"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>City, State, Zip:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="CityStateZip" size="60"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Phone:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="phone">&nbsp&nbsp&nbsp&nbspEmail:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="Email"></h3>
              <hr>
            </div>
          </div>

          <div class="floatcenter">
          </div>

          <div class="floatright">
            <div class="leftBorder" style="background-color: grey">
              <h3>Pet Information</h3>
            </div>
            <div style="text-align: left">
              <h3>Account Number:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="AccountNumber" size="40"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="petName" size="40"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Breed:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="Breed" size="40"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Age:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="age">&nbsp&nbsp&nbsp&nbspGender:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="Gender"></h3>
              <hr>
            </div>
          </div>
        </div>

        <div class="noBorder">
          <p class="regular">&nbsp&nbsp&nbsp&nbsp&nbsp<u>2. Diagnosis/Symptom Information&nbsp&nbsp&nbsp&nbsp<i>HELP US! By providing the "Story of Occurrence/Diagnosis," you will help us avoid delays in processing your claim.</i></u></p>
        </div>

        <div class="leftBorder">
          <h3><i>Story of Occurrence/Diagnosis&nbsp&nbsp&nbsp&nbsp&nbsp- Please describe this incident, including dates, details and symptoms leading up to it.</i></h3>
          <textarea class="default" rows="5" cols="204" name="Occurrence/Diagnosis"></textarea>
        </div>

        <div class="noBorder">
          <div class="leftright">
            <div style="text-align: left">
              <h3>This claim is related to:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="checkbox" name="Related" value="Accident">Accident<input type="checkbox" name="Related" value="Illness">Illness<input type="checkbox" name="Related" value="Wellness">Wellness</h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Is this claim an estimate for future treatment?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="checkbox" name="future" value="yes">Yes<input type="checkbox" name="future" value="no">No</h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Total amount claimed:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="totalAmount" size="60"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Date illness/injury first occurred:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="date" name="firstDate"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Send payment to:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="checkbox" name="payment" value="me">me<input type="checkbox" name="payment" value="Veterinarian">Veterinarian</h3>
              <hr>
            </div>
          </div>

          <div class="floatcenter">
          </div>

          <div class="floatright">
            <div style="text-align: left">
              <h3>Veterinarian:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="Veterinarian" size="40"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Clinic Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="ClinicName" size="40"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Phone:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="clinicPhone">&nbsp&nbsp&nbsp&nbspFax:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="ClinicFax"></h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Did any other veterinarian treat your pet?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="checkbox" name="otherVeterinarian" value="yes">Yes<input type="checkbox" name="otherVeterinarian" value="no">No</h3>
              <hr>
            </div>
            <div style="text-align: left">
              <h3>Is this a new condition?:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="checkbox" name="newCondition" value="yes">Yes<input type="checkbox" name="newCondition" value="no">No</h3>
              <hr>
            </div>
            <div><p>   </p></div>
          </div>
        </div>

        <div style="text-align:left">
          <p class="regular">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<u>3. Pet Owner Declaration&nbsp&nbsp&nbsp&nbsp</u></p>
        </div>

        <div style="text-align:left">
          <h3>I confirm to the best of my knowledge the above statements are true in every respect. I understand that the fees listed may not be covered or may
      exceed my plan benefit. I understand that I am financially responsible to my veterinarian for the entire treatment. I understand that this claim
      cannot be adjusted without itemized receipts. I also understand that the deliberate misrepresentation of the animal's condition or the omission of
      any material facts may result in the denial of the claim and/or the cancellation of coverage. I authorize United States Fire Insurance Company and
      its business partners to review and obtain a copy of ALL RECORDS including the insurance claim records and medical records as to examination,
      history, diagnosis, treatment and prognosis with respect to any condition. I further authorize these entities to disclose identifying information about
      me and my pet, as well as information about my claim experience, to my veterinarian.</h3>
        </div>

        <div style="text-align:left">
          <h3>Signature of Pet Owner:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="signature" size="40">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDate:<input type="date" name="signatureDate"></h3>
          <hr>
        </div>

        <div class="noBorder">
          <h2>Please read IMPORTANT NOTICE document that follows for additional information.</h2>
        </div>

        <div style="text-align:left">
          <p class="regular">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<u>4. 3 EasyWays to Submit a Claim Form&nbsp&nbsp&nbsp&nbsp<i>You must submit an itemized invoice with this claim form.</i></u></p>
        </div>

        <div class="noBorder">
          <div class="leftAuto">
            <h3>E-Mail:<br>
              claims@aspcapetinsurance.com<br>
              <i>scan and attach your receipts</i></h3>
          </div>

          <div class="centerAuto">
            <h3>Fax:<br>
              1-866-888-2495<br>
              <i>no cover sheet necessary</i></h3>
          </div>

          <div class="rightAuto">
            <h3>Mail:<br>
              ASPCA Pet Health Insurance<br>
              3840 Greentree Ave SW<br>
              Canton, Ohio 44706</h3>
          </div>
        </div>

        <div class="noBorder">
          <h3>* Please choose only one method. Duplicate claim submissions may delay processing.</h3>
        </div>

        <input type="submit" value="submit" style="height:400px; width:400px">
        </form>
      </div>        
        <%
            }
        %>
        

    </body>
</html>
