# rayTracer
***
a little project to demo custom raytracing

## Background
Gonna write a little blog of how I am deciding to make this in here as I figure this out.

Today is Thursday, March 31st, and over the next couple weeks I plan to create a simple renderer in Java. I've read up on different kinds of rendering technologies on a very surface level prior to writing this, and have taken a look at some things I will need in order to display my calculations onto some kind of display. Besides my existing knowledge, I would like to start off with just a very simple implementation of ray tracing spheres and cubes statically and optimize as much as I can before introducing small features like the ability to dynamically move or rotate objects. I'm choosing ray tracing because it's relatively straightforward and achievable considering my very low floor of knowledge.
---

## Day 1

First things first, I've gotta build a Vector class to handle all the fun interactions with vectors that I will inevitably have to work through. Some operations I know I'm going to have to use include the usuals of addition, subtraction, multiplication by a constant, dot products, and normalization. In this same vein I'm pretty sure I'm gonna have to make classes for each shape that I choose to include with specific operations for finding normals, or solving for intersections, etc.

I've also created a Main class that I'm gonna use (hopefully) temporarily as I make sure I can setup a display that I can control to a specificity I like. It's rather late so I'm gonna do some quick googling on setting up a BufferedImage for tomorrow. 
---
