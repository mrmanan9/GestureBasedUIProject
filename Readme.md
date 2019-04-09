### 4th YEAR GESTURE BASED UI DEVELOPMENT PROJECT 
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

#### Voice Commands 

| Command        | For?                    |
| -------------  |:-----------------------:|
| Start          | To starte the game      |
| Reset          | To Start the game Again | 
| Stop           | Pauses the game         | 
| Continue       | If paused then resumes  |


### Gestures identified as appropriate for this application


So we had a lot of choice in this project and a lot of freedom and we had to work in pairs 

![](https://image.slidesharecdn.com/bc61a10e-0b68-4c13-b562-6033eb4122c6-160222191323/95/presentation-1-5-638.jpg?cb=1456168437)

When we were given the Myo we had to research what gestures to use and we found that the Myo Armband has five built in gestures shown above. We decide to use the following:

![](https://support.getmyo.com/hc/en-us/article_attachments/201853983/make-fist.svg)
</br>
We decide to use the fist gesture to shoot. We began with  using the finger spread gesture for shooting but then decided to use fist.   This was done because the finger spread gesture was not as responsive as the fist gesture and it was more accurate to shoot with the     fist.

![](https://support.getmyo.com/hc/en-us/article_attachments/201806463/GestureOverlay_PresentationsFist.png)

We decided to use the rotate gestures for left and right movement. We initially had the wave-in and wave-out for moving right and left. Later on we found out that it was a bit tiresome and not as effcient so we decided to change this to the rotate. This does not require as much movement and stamina. 

### Hardware used in creating the application

#### Myo Armband 

The Hardware we are using for this project is Myo Armband. "The Myo armband lets you use the electrical activity in your muscles to wirelessly control your computer, phone, and other favourite digital technologies. ... The Myo armband. One Standard Micro-USB Cable for charging your Myo armband". 

<p align="center"> 
<img src="https://www.robotshop.com/media/catalog/product/cache/image/380x380/9df78eab33525d08d6e5fb8d27136e95/m/y/myo-gesture-control-armband-black-5.jpg"/>
</p>

Download
- We need to download the [SDK](https://support.getmyo.com/hc/en-us/articles/202657596-Getting-starting-with-Myo-on-Windows) 
- We also need to dowload the [Connector](https://support.getmyo.com/hc/en-us/articles/360018409792) 
- We need to download the following SDK and Connector to be able to use the Myo Armband and its gestures.
- Downloads are available for Windows and MAC and Android.

#### Microphone

"voice recognition is a computer software program or hardware device with the ability to decode the human voice". We use the microphone to detect voice to allow the user to be able to control the menu aspects of the game. 

![](https://s26913.pcdn.co/wp-content/uploads/AdobeStock_79969378-1024x440.jpeg)

### Architecture

This is the Architecture of our game.

![](https://github.com/nakster/gif/blob/master/arch.PNG)

#### Java 

This is the structure of our game. We have different packages for Enemies, Blocks and Bullets And the Runner with the jframe in the ie.gmit.sw package.

![](https://github.com/nakster/gif/blob/master/javaarch.png)

#### UML Diagram
![](https://github.com/nakster/gif/blob/master/uml.PNG)

#### Lua Script 
<p align="center"> 
<img src="http://www.lua.org/images/luaa.gif"/>
</p>

We used the LUA Scripting to connect our Java Game to Myo Armband. 

I am using LUA script with the java space Invaders to connect the Myo with the game. The Script allows The gestures to map to the keys on the keyboard.

- For example 

```Lua
  function toshoot()
    myo.keyboard("space","down")
    myo.vibrate("short")
  end

```

In the script we have a function that when called presses the spacebar key. We also have a method that is used to reset, So When the key is released the spacebar is also released.

- For example 

```Lua

  function resetShoot()
    myo.keyboard("space","up")
  end

```

The same applies to Rotate Left and Right the functions map the gestures to the keyboard keys. So When the user uses the rotate left gesture the lua script maps that to the left key and presses it down. 


#### Voice Recognition

```java
// for startint the game and quiting the menu 
public void sppech() {

  System.out.println("Say Start!");

  boolean start = false;
  while (!start)
  {
    // Normally, applications would do application-specific things 
    // here.  For this sample, we'll just sleep for a little bit.
    try
    {
      Thread.sleep(300);
    }
    catch (InterruptedException e)
    {
    }
    while (voce.SpeechInterface.getRecognizerQueueSize() > 0)
    {
      String s = voce.SpeechInterface.popRecognizedString();

      //check if s is equal to start 
      if(s.contentEquals("start")) {
        // if it is then end the loop 
        //					start = true;
        //start the game 
        startGame = true;
      }
      else if(s.contentEquals("stop")) {
        paused = true;
      }
      else if(s.contentEquals("continue")) {
        paused = false;
      }
      else if(s.contentEquals("reset")) {
        startAgain = true;
      }
      else{
        s = "empty";
      }
      System.out.println("You said: " + s);
    }

  }

  voce.SpeechInterface.destroy();

}
```

I am using the VOCE API to get the users voice. I have a continuous While loop which gets the user input. The input is then used to start the game, pause, resume and reset the game. I have boolean variables that are used to draw the menus when true.

#### Libraries
These are the libraries we used for the project above.

![](https://github.com/nakster/gif/blob/master/libraries.PNG)


#### Demonstration

[![Watch the video](https://thumbs.gfycat.com/FabulousRigidGrizzlybear-small.gif)](https://youtu.be/-0-hJeIND9Q)

### Conclusions & Recommendations

### Team Members
Naqi Ahmad
Nuzhafiq Iqbal 

### References 
[Getting Started With Your Myo Armband](https://support.getmyo.com/hc/en-us/articles/203398347-Getting-started-with-your-Myo-armband) </br>
[Installation](https://support.getmyo.com/hc/en-us/articles/202657596-Getting-starting-with-Myo-on-Windows) </br>
[Voice Recognition](https://www.computerhope.com/jargon/v/voicreco.htm)

