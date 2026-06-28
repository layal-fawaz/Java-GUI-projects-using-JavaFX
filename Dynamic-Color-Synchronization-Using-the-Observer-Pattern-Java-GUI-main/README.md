# Observer Pattern - Color Synchronization GUI

This project demonstrates the Observer design pattern through a GUI application where multiple windows synchronize color changes in real time.

## Project Description

When the user clicks a button to select a color (e.g., blue), the background window changes to that color and the text window updates to display the color name (e.g., "Blue").  

This synchronization happens automatically because the application uses the Observer Pattern:  
- A subject holds the selected color state.  
- Multiple observer windows listen for changes in this state.  
- When the color changes, all observers update their display accordingly without direct coupling.

## Features

- Color selection buttons  
- Real-time updates across multiple GUI windows  
- Clean separation of concerns using the Observer Pattern  

## Technologies

- Java  
- JavaFX  
- Design Patterns (Observer)  

---

Feel free to explore the code and see how the Observer Pattern enables synchronized UI updates!
