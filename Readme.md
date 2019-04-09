### 4th Year GESTURE BASED UI DEVELOPMENT PROJECT 
</br></br>

<p align="center"> 
<img src="https://github.com/nakster/gif/blob/master/spceinvaders.png"/>
</p>

### Overview

We had to develop an application with a Natural User Interface. We had a choice of technologies available to us and an opportunity to combine a lot of technologies that we have worked with over the past four years. We are required to complete a gesture based project. There were many options that we could have used. "The Myo armband measures electrical activity from your muscles to detect five gestures made by your hands. Using a 9-axis IMU, it also senses the motion, orientation and rotation of your forearm. The Myo armband transmits this information over a Bluetooth Smart connection to communicate with compatible devices." The Reason we went with the Myo Armband is because Myo was one of the better devices to control the game space invaders.   

This is a Gesture and Voice Controlled game that is controlled by your hand gestures and voice control. To make the game work with hand gestures we need to use the myo handband. The game is also started by saying "start" and can be paused and reset when defeated. 

### Purpose of the application – design of the application including the screens of the user interface and how it works. 

The purpose of this game is to demonstrate and implement various gesture controls using the Myo Armband. We made a game in java using eclipse and lua script with the myo Armband. The game also integrates speech recognition to start the game and pause, resume and reset. 

![](https://d262ilb51hltx0.cloudfront.net/max/2000/1*9uvS5j1EZXdQuIoqyb5syA.jpeg)

#### What the game looks like

![](https://github.com/nakster/gif/blob/master/invader.PNG)

#### How the Myo connects with the game

In the script we have a function that connects with the app. 

![](https://github.com/nakster/gif/blob/master/connect.png)

It returns true if it finds a application with the name GUI Project, this is the name I gave to the jframe in java.  

##### To connect 
You must run the LUA Script to be able to connect to the game. Double click the script and it should ask you to install and after installing the Myo Will be able to connect to the java game through the lua script.

<p align="center"> 
<img src="https://media.giphy.com/media/8UHhg0jG5aLjCbV45G/giphy.gif"/>
</p>


#### Voice Control 

I am using Voce to start the game. "Voce is a speech synthesis and recognition library that is cross-platform, accessible from Java and C++, and has a very small API. It uses CMU Sphinx4 and FreeTTS internally."



### start

When you say start the game will start playing. We have a set of strings that are already saved in a file called start.gram.

```shell

public <String> = [start | reset | stop | continue ];

```

These are used to recognise if the user says one of them to start and pause and reset. 

<p align="center"> 
<img src="https://media.giphy.com/media/fZVZ8bSkAlX5jbceiV/giphy.gif"/>
</p>

| Command        | For?                    |
| -------------  |:-----------------------:|
| Start          | To starte the game      |
| Reset          | To Start the game Again | 
| Stop           | Pauses the game         | 
| Continue       | If paused then resumes  |


### Gestures identified as appropriate for this application


So we had a lot of choice in this project and a lot of freedom and we had to work in pairs 

### Team Members
Naqi Ahmad
Nuzhafiq Iqbal 
