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
<br>

### Day 2
<br>
It's been a couple of real-time days since I've worked on this. I took a short bit of break while I was home for the weekend (translation, my parents wanted me to do yardwork). In the meantime, I have come up with a good list of things to knock out so that I can even get to raytracing. The first and most important thing is for me to start working on creating an image to display, or even developing the ability for me to display an image on the screen in the first place. 

<br>

There's definitely a couple different ways to display an image on-screen, whether Swing or the newer JavaFx. I decided to go with a BufferedImage in a JFrame for a couple reasons. First of all, using a BufferedImage lets me edit each pixel individually, something that I am going to be doing a lot. It also has a significant amount of documentation and troubleshooting already. Also, JavaFx is a little heavier, and has a lot of features that I'm not going to need if I'm calculating everything myself. I might look at this again in the future if I ever get to making the UI of the rayTracer a little prettier. I've also created another class to house all of the logic that I'm going to be using.

<br>

For my first run of the renderer, I'm not going to implement meshes. I don't think they are impossible for me to achieve, but I think I'd like to get some better experience with simple spheres and cubes before I get into those funky triangles. I'll still be implementing bits in the vector and shape code so that it will be easier for me to get meshes working in the future, though. In a similar vein, there is a very good chance I am over complicating the setup of the shapes, though I will try to not think about that while I get the rest of this set up. After today I should have all the setup necessary to start marching rays!

<br>

A little less importantly, I've also decided to call this project "Rendel", after my friends misread a scribble on my whiteboard that was meant to say "render". Good times.

---
<br>

### Day 3
<br>
Another day another chip away at Rendel. My baby boy has grown so much since the last update. Hopefully, by the time this is pushed, we'll finally be able to see shapes being rendered onto the screen. Without any reflections or any depth. Today I officially gave up on working on this all by myself, but only for just a little bit. I was trying to figure out how I would work in shading, and wrote out a couple bare minimum recursive functions that worked with rays. I worked myself into this weird corner where I would have to look at every lighting source in the scene for each pixel and its corresponding shape. It felt like calculations of this amount would just be so incredibly taxing on hardware, and that there was no way a computer would be expected to keep track of layers on layers of diffusion and reflection, but turns out I was almost right and computers just do this kind of stuff on the daily. Good for them :)

<br>

Besides melting into a puddle thinking about how incredibly complex raytracing in video games is, I also worked through some more things. A lot of what happened today was through trying to put functions in places that would use them best, and also trying to optimize a little with what I have. I am genuinely a little concerned for my laptop when I run this, so I tried making some little adjustments, like trying to presort the list of shapes in order of distance from the camera and just choosing the closest shape/color. Unfortunately, that runs in to weird corner cases when shapes are within other shapes, or when the shapes are not just all spheres. If a sphere and a cube are the same size, a corner of the cube could actually be closer to the camera than the sphere is, even though its position is a little further away. 

<br>

At the end of the day, with seconds left on the clock, I managed to do what UNC could not and finished strong (reference to NCAA finals that will age poorly). After many hours of grinding out bug after bug, I was finally able to... draw a circle!!! Yay!!! Though there are undoubtedly much more efficient ways to draw a circle, this circle is my baby of a couple hours of work, and I am proud. Multiple spheres layered draw at the same time takes noticeably longer, and it is very visible when you go to make a couple dozen spheres. For now I'll stick three of them there and not think about it too much. Despite the fun I am having messing around with circles there is a slight problem with how things are displayed. For now, the x axis is horizontal as always, but the y axis is flipped. It is 2 AM and I am sure there is some easy fix, but right now is not the time to delve into that. Hopefully I can get a handle on that by tomorrow.

<br>

It is now 3 AM and I have had so much fun making my little spheres intersect that I added a little animation of spheres intersecting! :)

---
<br>

### Day 4
<br>
I've had so much fun messing around with making these spheres move around! I think at some point I'm gonna write a small library for animating these guys. Huh. Anyway, what's on the menu today is an implementation of perspective view. This didn't end up taking too long. All the code works for orthographic, so using a custom direction vector instead of the basic orthographic vector is just a single swap. I had to define a focal point in relation to the camera plane, but that's not really a biggie. The z offset of the focal length is kind of arbitrary, though. In games I've played before, the FOV was something that the player can define, but for a purpose like this, I might want to look up a way to hardcode it.

<br>

While I was doing that, I went head and unflipped my y axis. It wasn't that bad either. BufferedImage sets pixel values from the top left, as most applications do, and fixing it just made me replace "j" with "height-j-1". Now that I have orthographic and perspective working fine, I'm gonna start work implementing proper raytracing lighting and shading, which I hope to finish by tomorrow or the day after. 

---
<br>

### Day 5
<br>
Yea, so I'm gonna have to break my rules a little bit. After a good long while trying out different models of lighting to absolutely no avail, I finally decided to bend my rules a little and research different kinds of lighting online, being careful to avoid any actual implementations of either that lighting or raytracing engines in general. What I found was insane. Holy mother of god I had no idea lighting was this complicated. There are so many layers. on layers. WHY CAN YOU MULTIPLY COLORS??? THAT DOESN'T EVEN MAKE ANY SENSE!!!!! I searched around some, and I think I'm going to try my hand at the Phong reflection model, pretty much only because its the most well-documented model that's been going on for quite a while now. I might have to make some alterations eventually when reflections come to play, but for now, it's fair game.

<br>

First things first, I messed with the order of the state machine a little bit in the ImageFiller class so I can more easily implement the new form of Phong shading while still keeping the project's original flat shading intact.

<br>
That went better than anticipated, and the code looks a lot better. I can also structure the different ways of shading in a similar manner as I work through Phong shading. I think that what will be easiest is to separate the three bits of Phong shading, being ambient, diffusion, and specular, into three different colors so I can see how it renders each of the lighting systems individually, and then together. Unfortunately, I've put off doing shading for the past couple hours because it is difficult and I still don't fully understand how the constants work, and have opted instead to add a bunch more customization options. Now, the animation can not only be paused, but can be cycled through different rendering implementations (that I have yet to make). I helped it along with an observer style render on the pause function so we can get some nice looking paused renders, though I'll have to redo the way I do the animations for a more stable frame rate instead of the current render/thread sleep format it is right now.

---
<br>

### Day 6
<br>
Alright so I finally got around to doing some lighting. Before that though, I added some more options for interacting with the variables through key presses just so its a little easier to debug. Now I don't have to change code, just gotta hit the spacebar, z key, and comma key to toggle color renderers, perspective, and pause respectively. I also changed how I do color, because if I'm being honest, I never really used the alpha channel. Now it's a little more readable and easier to create new shapes and stuff. Yay! Now onto the lighting bits.

<br>
First things first, I added a Light class to keep track of the positions of light out and about. I might add something to control intensity later but as of now everything is the same. I also added ambient light relatively easily. All I had to do was multiply the current color of the renderer by a constant dictated by the material. Next is the diffused light. The equations for both diffusion and specular illumination are straight from Wikipedia, and my implementations of that are also pretty straightforward. I would say the most difficult part is tuning things and knowing where the bugs make themselves apparent. For example, I thought that my diffusion equations were somehow backwards, but it was actually the fact that I didn't clamp the Color from going below zero, which for some reason broke everything. You live and you learn :/.

<br>
Now that I've set everything up, the Phong lighting works! There is a little problem with specular lighting though, which is creating a weird halo effect on the spheres. I don't know why its doing that but it is and it is really bothering me, mainly because it looks like the spheres are dimpled in a funky way. I suspect I forgot to normalize something, or that a dot product somewhere is acting real funky, but that's something for me to figure out later. For now, I will play with my pretty little spheres.

---