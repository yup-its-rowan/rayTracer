# rayTracer

a little project to demo custom raytracing by Rohan Akki
<br>
<br>
<br>


## Background
<br>
Gonna write a little blog of how I am deciding to make this in here as I figure this out.

<br>

Today is Thursday, March 31st, and over the next couple weeks I plan to create a simple renderer in Java. I've read up on different kinds of rendering technologies on a very surface level prior to writing this, and have taken a look at some things I will need in order to display my calculations onto some kind of display. Besides my existing knowledge, I would like to start off with just a very simple implementation of ray tracing spheres and cubes statically and optimize as much as I can before introducing small features like the ability to dynamically move or rotate objects. I'm choosing ray tracing because it's relatively straightforward and achievable considering my very low floor of knowledge.


---
<br>

### Day 1
<br>
First things first, I've gotta build a Vector class to handle all the fun interactions with vectors that I will inevitably have to work through. Some operations I know I'm going to have to use include the usuals of addition, subtraction, multiplication by a constant, dot products, and normalization. In this same vein I'm pretty sure I'm gonna have to make classes for each shape that I choose to include with specific operations for finding normals, or solving for intersections, etc.

<br>

I've also created a Main class that I'm gonna use (hopefully) temporarily as I make sure I can setup a display that I can control to a specificity I like. It's rather late so I'm gonna do some quick googling on setting up a BufferedImage for tomorrow. 

---

### Day 2
It's been a couple of real-time days since I've worked on this. I took a short bit of break while I was home for the weekend (translation, my parents wanted me to do yardwork). In the meantime, though I have come up with a good list of things to knock out so that I can even get to raytracing. The first and most important thing is for me to start working on creating an image to display, or even developing the ability for me to display an image on the screen in the first place. 

<br>

There's definitely a couple different ways to display an image on-screen, whether Swing or the newer JavaFx. I decided to go with a BufferedImage in a JFrame for a couple reasons. First of all, using a BufferedImage lets me edit each pixel individually, something that I am going to be doing a lot. It also has a significant amount of documentation and troubleshooting already. Also, JavaFx is a little heavier, and has a lot of features that I'm not going to need if I'm calculating everything myself. I might look at this again in the future if I ever get to making the UI of the rayTracer a little prettier. I've also created another class to house all of the logic that I'm going to be using.

<br>

For my first run of the renderer, I'm not going to implement meshes. I don't think they are impossible for me to achieve, but I think I'd like to get some better experience with simple spheres and cubes before I get into those funky triangles. I'll still be implementing bits in the vector and shape code so that it will be easier for me to get meshes working in the future, though. In a similar vein, there is a very good chance I am over complicating the setup of the shapes, though I will try to not think about that while I get the rest of this set up. After today I should have all the setup necessary to start marching rays!

<br>

A little less importantly, I've also decided to call this project "Rendel", after my friends misread a scribble on my whiteboard that was meant to say "render". Good times.

---