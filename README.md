# transformerDemo: Moble Developer Techinical Test Report

This is an android demo for XXX company only, the purpose of this application is to show my experience and some thoughts of the requirement about how to implement a battle among transformers.

# Development Environment: 
Android Studio running on Google Cloud VM which could not run virtual device. I also use a Macbook to debug and simulator purpose.

# Technical Implementation and Thoughts

I’d like to show two parts in this assessment, the first one is Java development. In order to implement this game, I use the Strategy design pattern to implement a simple game rule according to the requirement in the document. Some Junit tests have been created to verify the rules.

The second one is Android development. I use MVVM architecture to design this application via Data Binding feature from Google team. I started to learn and use Data Binding feature from 2016 to double bind the data between UI views and java POJOs.

Another thoughts about the android application architecture is to use Event Bus. I started to use it from 2015, the advantage is the ability to decouple the heavy Activity classes, and move the business logic into service layer. 

I also use retrofit 2 in order to act as network communication layer via RESTful APIs. For this transformer APIs, it’s a basic and well designed APIs, it’s user-friendly as well. So the code is clear.

The challenge of this application is the requirement to support android 4.4, the APIs from firebase which only support https and new version of TLS, as a result, the android 4.4 could not support non-certification https protocol because the default is off. In order to use retrofit 2 to support https, there is specific TLSSocketFactory Java class.

Finally, as a full-stack developer, I have enough experience in Java back-end, since this position need APP development as well, I hope this code can help you to learn my technical background. 

The following are the screenshot:
![Screenshot 1](https://raw.githubusercontent.com/fullstackdevelopercandidate/transformerDemo/master/demoimage/screen1.png)
![Screenshot 2](https://raw.githubusercontent.com/fullstackdevelopercandidate/transformerDemo/master/demoimage/screen2.png)
![Screenshot 3](https://raw.githubusercontent.com/fullstackdevelopercandidate/transformerDemo/master/demoimage/screen3.png)
