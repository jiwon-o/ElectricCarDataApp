![전기차](https://user-images.githubusercontent.com/64193469/213198155-addc13e4-e73e-43ae-ad2b-00a62550bb25.png)
![전기차2-min](https://user-images.githubusercontent.com/64193469/213198198-906c75f9-f003-4602-9b6c-f9e29920e1ca.gif)
![전기차3-min](https://user-images.githubusercontent.com/64193469/213198204-8fed26db-1714-4102-a5c4-40b12fcef806.gif)
![전기차4-min](https://user-images.githubusercontent.com/64193469/213198218-99c8738b-1fd0-4f20-97cc-945428315cde.gif)
![전기차5](https://user-images.githubusercontent.com/64193469/213198258-4282e33c-11e3-4369-bea1-a0282b6f1717.png)
![전기차6-min](https://user-images.githubusercontent.com/64193469/213198281-0163f729-4557-4f62-bb38-ba7b32d3eae4.gif)
![전기차7-min](https://user-images.githubusercontent.com/64193469/213198307-87b3b775-aba6-45b2-b6a8-ea966c21605c.gif)


Author: AppForest.kr
Date: February 2021
Description: Car Layout

(*This product has layout only, with only essential features added to operate the layout.*)

Rights: copyrighted templates and code. 
Some templates and code (Eg Graph,Animation) use the following APIs and libraries: *MPandido Chart Created by Philipp Jahoda* *Lottie Animation by Rishabh Goel*
​
Animation by Rishabh Goel on LottieFiles
Rishabh Goel on LottieFiles: https://lottiefiles.com/11808-electricity-loading

You are licensed under Apache License Version 2.0 ("License"), and you cannot use this file except for license compliance. You can obtain a copy of the license.

http://www.apache.org/licenses/LICENSE-2.0

Copyright 2021 © AppForest.kr, Copyright 2020 Philippe Jahoda Philipp Jahoda

https;//AppForest.kr


#How to use
1. How to change the design
If you want to change the design, you can modify it by referring to the xml files in layout.

2. How to change the graph design
To customize the design of a graph
you can create your own custom in "DataFragment_month.java", "DataFragment_week.java", and "DataFragment_year.java".

3. How to change the data on a graph
To change the data on a graph
You can use the database to invoke it as a data function set in the activity.

4. How to change animation
You can easily change it from xml in the anim folder.
If you want to change to code, refer to the buttonAnimation function in "HomeFragmentation.java".

5. How to change the navigation bar design
You can change the color in color/bottom_navigation_colors.xml.
You can change the image in layout/activity_main.xml.
You can change the linked page in MainActivity.java.


#control Detail Page
1. Climate
This is a layout that can control the temperature of the car.
The buttons in Mode are set to show a different layout when on/off.
The temperature can only be changed when button is pressed.
If you want to change the design method or link the data, modify it in "Temperature Activity.java".

2. Battery
This is a layout where you can see the usage of your car.
The graph was used in the layout to make it easier for users to see their figures.
If you want to add actual operating functions or change the layout, modify it in "Battery Activity.java".

3. Light
This is a layout that controls the internal and external functions of the car.
if you want to add actual operating functions, modify it in "Light Activity.java".

4. Camera
This is a layout where you check the black box on your phone.
We have set the current time to receive it, and we have used a cell phone camera to show an example of operation effectively.
If you want to bring in another camera, modify it in "CameraActivity.java".

5. Music
This is a layout that plays music using a list view.
If you want to run the actual data linked, modify it in "MusicActivity.java", "ListViewAdapter.java", and "ListViewItem.java".

6. Door
This is a layout that controls the door of the car.
You can control the entire image through the buttons, and you can also change individual images.
As an open image, the warning light that tells the car door is open is expressed in layout with animation.
If you want to run the actual data linked, modify it in "DoorActivity.java"
