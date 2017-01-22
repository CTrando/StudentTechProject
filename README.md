#Student Tech Project
Before I got into the graphics framework libGDX, I was very interested in Swing, which has been replaced by JavaFX. But before I knew about that, I did everything in Swing. **This whole project is done in Swing.**

As part of my internship in summer 2016, I had to do a big project, so being interested in Swing, I decided to try and make a pseudo-website completely with Java Swing. As I had an extreme amount of control over everything, I tried to make it more efficient than a website made with HTML. As expected, I failed, but I did end up developing something pretty cool. 

----------
#Implemented Features
- Scrolling with both the mouse wheel and moving the mouse (had to use a lot of mouse listeners and work with the coordinate system)
- Escape will bring you back to the previous page (knowing what I know now, I would use a stack system for remembering previously visited pages - but I didn't know that at the time)
- Full screen with F11
- Different pages
- Images (represented as Buffered Images)
- System of placing images 
- Text centering (implemented recursively - extremely difficult to implement)

-----------
#Final Notes
Looking back at this project, I have no idea how I was able to create such a complex program in a few weeks.

Unfortunately, I was unable to increase the performance of this program because of the speed of reading input of large images. Swing is also inefficient at drawing large files as well. I was able to overcome some obstacles by only loading images when I need them; however, I did not know about 'lazy loading' or other practices, so the speed was generally unsatisfactory. 

Overall, a great learning experience with Swing, and I'm very happy with what I accomplished.
