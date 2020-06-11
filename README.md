# VentLog - Event Logger

Project Number: 1G

Title: VentLog

Description: An app that you can save what you did on a certain day then add comments based on how these things made you feel, what they made you think, which people you’ve been to these things with, thoughts that you want to remember when you did these activities.

Tools: Android Studio version 3.1.2. / Firebase authentication(12.0.1) library, Firebase database(12.0.1) library, Firebase storage(12.0.1) library, Picasso v.:2.71828 libraries used for this project.

Setup: Open Android Studio. Open: Configure/SDK Manager/SDK Platforms. Be sure Android 6.0 (API 23) is installed at your IDE.
Then click "Open an existing android studio project". Find VentLog folder and and click Ok. Gradle will build the project. After it is builded,click run, there must
be a connected device to run the app. You can use an emulator by creating it from Tools/AVD Manager/Create Virtual Device. But it is better to connect some real Android phone.
(SDK versions must match with project in either case.) 

Its Current Status: We implemented the EventAdding page and by using Firebase we displayed the Events, which are inserted, in MyLog Page. We were not able to implement Group Log page. We implemented Settings page, however we did not implement Collage and MoodFixer. We could not prepare fully working xml’s for Trash and Archive page.

Each member's contributions:

Meryem Banu Cavlak
- I founded an idea for the project, discussed other ideas.
- Contributed to Requirements Stage, wrote some parts of the report, took part in presentation and had suggestions on advancing it. Suggestions for Critique also.
- I prepared our sitemap for UI design and wrote some parts in report and the critique.
- I wrote some parts of our code (mainly Settings activity and xml's related to it and some basic other parts to improve current code), attended meetings to contributed combining our code. I revised the Detailed-Design report. Lastly, I tried to keep wiki updated.

Tuana Türkmen
- Contributing to write an email to consult our instructor about our project topic.
- Contributing to the Requirement Report.
- Sharing new ideas after the feedback of the Requirement Report.
- Contributing to the Requirement Report Critique.
- Preparing some of the presentation and presenting it.
- Sharing ideas about changing some of the main aspects of the project.
- Writing my part of the finalized Requirement Report.
- Writing my part of the UI design and getting all parts together.
- Writing my part of the critique of one of the other group’s UI design.
- Presenting some suggestions.
- Preparing the UI Design presentation.
- Presenting the UI Design presentation.
- Contributing to the UML Design of the project.
- Making the log-in page part of the code.
- Discussing and talking about the almost finished code.
- Writing the code of the Event Page xml.

Utku Kalkanlı
- Discussing ideas for project.
- Writing some parts of UI design stage, Requirements report, discussing ideas for Detailed Design stage.
- Setting up Firebase server. Setting up Firebase Authentication(log-in,sign-up), Realtime Database and Storage in project.
- Log in and sign up methods.
- Asking gallery access permission methods to user.
- Event adding(sending data) to database and getting data from database.
- GUI(.xml) of MyLog, Event Adding and MainActivity(log-in,signup).
- Setting up Picasso,image downloading and caching library for Android, using it to catch image from Firebase.
- PostEvent class, takes Firebase data and turns it into event view.
- Listview of MyLog.
- Javadoc of some classes.
- Integrating some parts of the code. 

Munib Emre Sevilgen
- Came up with an idea to form our project
- Contributed to the Requirement Report.
- Contributed to the Requirement Report Critique.
- Prepared some parts in the Requirement Report presentation and the template of the presentation.
- Presented my parts of the presentation.
- Wrote my parts for the revised Requirement Report.
- Prepared the screenshots for the User Design Report.
- Contributed to write the critique of Group 1F’s UI Design Report.
- Contributed to prepare the UI Design presentation.
- Contributed to revise our UI Design Report.
- Prepared the UML diagram for the Detailed Design Report.
- Wrote my part of the Detailed Design Report.
- Wrote some of the Java classes that will work behind the Android codes. (Archive, Cinema, Event, EventContainer, GroupLog, Log, MyLog, Template and Trash)
- Wrote some of the Android classes and xmls. (ShowEventActivity class, Menu xmls and MyLog class)

Ece Çanga
- I have updated the design of the wiki page.
- I have done contributions in the Requirements stage, writing some parts of the report and presenting it.
- I revised some parts of the UI design report and presented it.
- I made suggestions about improving our app’s UI design.
- I wrote the code for some of the Java classes (VentLog, User, Settings classes) and wrote the code for search bar (SearchActivity, SearchAdapter classes and the xmls for them).
- I attended meetings to combine our code. However, we could not combine the code for search bar since the xml file for the code was not matching with our xml layout.

Efe Dağdemir
- Brainstormed ideas with my team members.
- Wrote some parts of the Requirements Report,  noted the questions and suggestions in the presentations. Contributed to the critique of the other group.
- Came together with my group and exchanged ideas about changing some of the features of our project.
- Wrote some parts of the final requirements report.
- Prepared my slides for the UI Design presentation.
- Presented my part of the UI Design presentation.
- Helped with the UML design.
- Created the login page and the xml of the Event Page.

References:

https://www.udemy.com/android-o-mobil-uygulama-dersi-kotlin-java/learn/v4/overview

https://www.youtube.com/watch?v=hREyErUJu6I

https://github.com/DushyantMainwal/FirebaseDemo

