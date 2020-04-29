# AndroidProject3

Authors: Tristan Durey and Jon Curnutt

Description: This application allows users to access the OMDb API through an accessible UI and add movies to their own personal vault. The main screen will display added movies and TV shows along with their corresponding poster images if one is available. Clicking on an added movie will open a new activity that displays in-depth detail about the selected show or movie. In the main screen, users can delete items at any time by long pressing on the item they wish to delete. The settings screen allows users to customize the app's theme and specify the order in which their items are displyed. 

- All settings are saved in shared preferences
- The Room persistence library is used so user data is stored even after sessions are ended.

Teammate contributions: 50-50

Jon Curnutt: 
- API functionality 
- Settings functionality and general xml design
- Shared preferences functionality

Tristan Durey:
- Room persistence library functionality with SQLite
- XML layout and database correspondence for movie/show details activity
- Recycler view on main screen
