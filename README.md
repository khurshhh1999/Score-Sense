# Score Sense Project Installation Guide for CSYE 6200

Thank you for choosing Score Sense! Follow the steps below to get started with the installation process.

_______________________________________
#### Step 1: Unzip the Score_Sense_zip file
Download the Score_Sense_zip file and unzip it on your computer.
___________________________________________________________
#### Step 2: Copy the Unzipped Folder to Eclipse Work Directory
Copy the unzipped folder to your Eclipse work directory.
________________________________________
#### Step 3: Import the Project into Eclipse
Open Eclipse.
Go to File > Import... > General > Existing Projects into Workspace.
Select Select root directory > Browse... > Enter your Eclipse work directory.
Choose the Score Sense project in the Projects window.
Click on Finish.
_______________________________________
#### Step 4: Install DB Browser for SQLite
Install the version suitable for your computer of DB Browser for SQLite from https://sqlitebrowser.org/dl/.
__________________________________________
#### Step 5: Configure the Database Connection
Open the DBConnection.java class in Eclipse.
Replace the path of the ScoreSenseUsers.db with the path on your computer.
Note: The ScoreSenseUsers.db is included in the Score Sense project.
_____________________________________________
#### Step 6: Open and Run the Score Sense Project
Open the imported Score Sense project in Eclipse.
Locate the Main.java file in the project.
Right-click on Main.java > Run As > Run Configurations...
In the Arguments tab, set the VM arguments to: --add-modules javafx.controls,javafx.fxml
Uncheck the option for "Use the -XX:+ShowCodeDetailsInExceptionMessages" when launching.
Click Apply > Run.
__________________________________________
#### Step 7: Create Your Account and Score UP!
Once the application is running, follow the on-screen instructions to create your account and start scoring!
