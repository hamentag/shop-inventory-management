<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 

## SUPPLEMENTAL RESOURCES  
1.	How to clone a project to IntelliJ using Git?

> Ensure that you have Git installed on your system and that IntelliJ is installed using [Toolbox](https://www.jetbrains.com/toolbox-app/). Make sure that you are using version 2022.3.2. Once this has been confirmed, click the clone button and use the 'IntelliJ IDEA (HTTPS)' button. This will open IntelliJ with a prompt to clone the proejct. Save it in a safe location for the directory and press clone. IntelliJ will prompt you for your credentials. Enter in your WGU Credentials and the project will be cloned onto your local machine.  

2. How to create a branch and start Development?

- GitLab method
> Press the '+' button located near your branch name. In the dropdown list, press the 'New branch' button. This will allow you to create a name for your branch. Once the branch has been named, you can select 'Create Branch' to push the branch to your repository.

- IntelliJ method
> In IntelliJ, Go to the 'Git' button on the top toolbar. Select the new branch option and create a name for the branch. Make sure checkout branch is selected and press create. You can now add a commit message and push the new branch to the local repo.

## SUPPORT
If you need additional support, please navigate to the course page and reach out to your course instructor.
## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!
## DESCRIPTION (Task B)
### Task C:
>  - Prompt:  
> Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
> 
> 
>- Files:
   • mainscreen.html / Lines: 14, 19, 21-42  
   • demo.css / Lines 1-11  
   • README.md / Lines 27-43
> 
> 
>  - Changes:  
Added the shop name, the product names, and the names of the parts to the interface  
Added some styles  
Parts: Flour, Butter, Eggs, Milk, Vanilla Extract  
Products: Birthday Cakes, Cupcakes, Croissants, Cookies, Tarts
> 
> 



### Task D:
>  - Prompt:  
  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
>
> 
>  - Files:  
   • about.html / Lines: All  
   • mainscreen.html / Lines: 18-24  
   • demo.css / Lines 16-71  
   • README.md / Lines 49-63  
   • InhousePartForm.html / Lines 7-21 (styling)  
   • OutsourcedPartForm.html / Lines 6-21 (styling)  
>
> 
>  - Changes:  
Added the about page to the application  
The “About” page includes navigation to and from the “About” page and the main screen (Home button)
> 
>


### Task E:
>  - Prompt:  
Add a sample inventory appropriate for your chosen store to the application. 
You should have five parts and five products in your sample inventory and should not 
overwrite existing data in the database.  
Note: Make sure the sample inventory is added only when both the part and product lists 
are empty. When adding the sample inventory appropriate for the store, the inventory is 
stored in a set so duplicate items cannot be added to your products. When duplicate items 
are added, make a “multi_pack” part.
> 
> - Files:  
  • InhousePart.java / Lines: 20-23  
  • OutsourcePart.java / Lines: 20-25  
  • BootStrapData.java / Lines: 46-62, 82-93  
  • README.md / Lines 70-84  
>
>


### Task F:
>  - Prompt:  
     Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:  
     • The “Buy Now” button must be next to the buttons that update and delete products.  
     • The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.  
     • Display a message that indicates the success or failure of a purchase.
> 
> 
> - Files:  
  • mainscreen.html / Line: 109  
  • AddProductController.java / Lines: 115-131  
  • ConfirmationBuyProduct.html / Lines: All  
  • ProductService.java / Line: 20  
  • ProductServiceImpl.java / Lines: 71-84  
  • README.md / Lines 89-111  
  • purchaseFailure.html / Lines: All
>
>
>  - Changes:  
Added a method decrementInv(long productId, int decAmount); to the product service implementation. 
The method accepts two arguments long productId for the product Id and int decAmount for 
the amount by which the inventory should be decremented. @Transactional is used to update 
the product inventory by using setter setInv() and without implement any jpql query.
> 
>

### Task G:
>  - Prompt: 
Modify the parts to track maximum and minimum inventory by doing the following:  
• Add additional fields to the part entity for maximum and minimum inventory.  
• Modify the sample inventory to include the maximum and minimum fields.  
• Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs 
for the inventory so the user can set the maximum and minimum values.  
• Rename the file the persistent storage is saved to.  
• Modify the code to enforce that the inventory is between or at the minimum and maximum value.  
>
> - Files:  
    • BootStrapData.java / Line: 46-117  
    • AddInhousePartController.java / Lines: 45-65  
    • AddOutsourcedPartController.java / Lines: 45-65  
    • InhousePart.java / Lines: 20-21  
    • OutsourcedPart.java / Lines: 20-25  
    • Part.java / Lines: 31-34, 44-58, 105-110  
    • InhousePartForm.html / Lines: 37-41  
    • OutsourcedPartForm.html / Lines: 37-41  
    • application.properties / Line: 6  
    • README.md / Lines:  Lines: 117-149  
> 
>
>  - Changes:  
     • minInv and maxInv are added to the Part entity  
     • Sample inventory is modified to include minInv and maxInv and validation for (minInv < maxInv) and (minInv < inv < maxInv) constraints  
     • Input fields are added so the user can set the minInv and maxInv  
     • Features are added to check that (minInv < maxInv) and (minInv < inv < maxInv) constraints are assured  
     • spring.datasource.url in application.properties is renamed  
> 
>


### Task H:
>  - Prompt:
     Add validation for between or at the maximum and minimum fields. The validation must include the following:  
     • Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.  
     • Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.  
     • Display error messages when adding and updating parts if the inventory is greater than the maximum.  
>
>
> - Files:  
    • BootStrapData.java / Line: 46-117  
    • AddInhousePartController.java / Lines: 39-60  
    • AddOutsourcedPartController.java / Lines: 40-66 
    • AddProductController.java / Lines: 78-120  
    • Part.java / Lines: 138-144  
    • PartService / Line: 20  
    • PartServiceImpl / Lines: 69-73  
    • demo.css / Lines: 61-112  
    • mainscreen.html / Lines: 21-24  
    • InhousePartForm.html / Lines: 23-52  
    • OutsourcedPartForm.html / Lines: 24-46  
    • productForm.java / Line: 25-44  
    • README.md / Lines: 148-176  
>
> 
> - Changes:  
    • Error messages are displayed when inventory is not between min and max values  
    • Error messages are displayed when max inventory is less than min inventory  
    • Page styling is added to the application


### Task I:
>  - Prompt:  
     Add at least two unit tests for the maximum and minimum fields to the PartTest class 
in the test package.
>
> - Files:  
    • PartTest.java / Lines: 160-235
    • README.md / Lines: 178-185



