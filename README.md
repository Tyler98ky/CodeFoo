# CodeFoo
This is the main repository for the source code for the android app.

Link for Lincoln Logs Empire State Building solution
-----------------------------------------------------
This is my solution to building the Empire State Building out of Lincoln Logs. <br/><br/>
https://github.com/Tyler98ky/CodeFoo/tree/master/Code%20Foo%20Lincoln%20Logs

Link for Chained Grid Challenge
-----------------------------------------------------
This is the link to the chained grid part of the application, in another repo. <br/><br/>
https://github.com/Tyler98ky/Code-Foo-Grid

Link for YouTube video
-----------------------------------------------------
IGN Code Foo 2017 <br/><br/>
https://www.youtube.com/watch?v=B9JbSnUSFCs

# Description of the App
Hi, so the challenge said to build a native app that as closely as possible resembled the current IGN mobile app's design, while making any changing I thought would make sense. I took this pretty drastically, and chose to completely change the design of the app to the modern specifications of UI guidelines of native android apps, material design. I still used the api to pull a list of the articles and display each article, but I made some design changes.<br/><br/> First off, integeral to this material design specification, I used a fairly new android feature called CardViews and Recyclers. The Card Views, which you can see in the screenshots below, are the actual objects of each article. Each article is displayed on its own Card View. This is a much more modern approach to the UI than the alternative of making each article a part of a simple android List View, and more importantly, follows the new android convention of material design. Each one of these Card Views currently hold the title of the article, an image of the article, and the time elapsed since the article was published (which I know makes less sense in this application since the API uses articles that were posted a month ago, but in actual practice in would follow IGN's current article layouts on the website and app).<br/><br/> This material design places heavy emphasis on shadows and the 3 dimensional feel you get from using the design pattern. In this app, shadows are used to make each card feel as if they are floating above the background of the screen, and then as you scroll, slide underneath the title bar of the application. This 3 dimensional effect is quite nice from a user experience perspective.<br/><br/> My app's design is still very simplistic however, but I did this to use the app as more of a template for what changes I would make, rather than create a perfect example of material design. I also made a pretty big change in the color scheme of the app. The example used in the challenge follows the theme and design patterns of the pretty old IGN webiste theme, that has been gone for at least a few years now. It has a very dark color palette, whereas the new IGN website has a very vibrant and bright theme now, so my app mirrors the new website conventions much more so than the current IGN mobile app does, with a main color scheme of white and red.  <br/><br/> \*I'd also like to just add that given I found out about this challenge code very late, my time constraints for making this were very strict, so I definitely understand there needs to be quite a few optimizations made to the app! I still was able to make something that I feel gets across what I wanted to do with this challenge and I hope you all enjoy this! Can't wait to hear back from you guys.\*

## Screenshots
<img src="/ReadMe_Images/device-2017-03-20-083012.png" width="685" height="1267">
<img src="ReadMe_Images/device-2017-03-20-083119.png" width="685" height="1267">
