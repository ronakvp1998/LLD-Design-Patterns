# Music Player UML Diagram: Detailed Explanation with What, Why, and How

---

## 1. MusicPlayerFacade (Singleton, Facade Pattern)

### What
- Central manager and interface for the whole music player system.
- Only one instance exists (Singleton): All operations like creating playlists, connecting devices, and playing music go through this class.

### Why
- Centralizes all control logic—so users/other classes don’t deal with internal complexities (e.g., device selection or playback logic).
- Singleton ensures only one “brain” runs the application, avoiding conflicts.

### How
- Keeps collections of songs/playlists.
- Methods call relevant subsystems (like Playlist, DeviceFactory).
- Changes playback strategy and output device as needed.
- Handles state management (via PlayState).

#### Main Methods (What / Why / How):

| Method                        | What it Does                                                      | Why Needed                                                  | How it Works                                       |
|------------------------------|------------------------------------------------------------------|-------------------------------------------------------------|---------------------------------------------------|
| `createPlaylist(string name)` | Creates a new playlist and adds it to system.                   | Users want to group songs.                                   | Instantiates new Playlist object, adds to map.    |
| `loadPlaylist(string name)`   | Loads a playlist by its name.                                    | Let user access previous playlists.                         | Fetches from playlists map.                        |
| `addSong(Song song)`          | Adds a song to the currently selected playlist.                 | Users add music to playlists.                               | Calls Playlist’s `addSong`.                        |
| `playSong(Song song)`         | Begins playback for specified song.                             | Core player function.                                       | Uses strategy/state to start playback via device. |
| `pauseSong(Song song)`        | Pauses current song playback.                                   | User needs pause control.                                   | Calls PlayState to manage pause logic.            |
| `playAll()`                   | Plays all songs in the active playlist using the selected strategy. | Users may want to listen to all songs sequentially or shuffled. | Loops through current playlist per play strategy. |
| `setStrategy(StrategyType st)`| Changes playback order (e.g., shuffle or sequential).           | Customizes listening experience.                            | Swaps Playlist strategy (Strategy Pattern).       |
| `connectDevice(DeviceType dt)`| Connects to chosen output device (Bluetooth, wired, headphones). | Music can be played on various outputs.                     | Uses DeviceFactory to instantiate and set device. |
| `setPlaylist(Playlist pl)`    | Changes or sets the current active playlist.                    | Switch playlists easily.                                    | Replaces/assigns current playlist variable.       |

---

## 2. Song

### What
- Represents a single music file (title, artist, etc).

### Why
- Fundamental unit of music—every track must be its own object for organization/playback/statistics.

### How
- Instantiated for every new song with required metadata.
- Provides data to Playlist, Facade, and Device during operations.

#### Key Attributes & Methods:
- `Song(string title)` — Constructor initializes with vital attributes.
- *Getters/Setters* — Access or update song details as needed.

---

## 3. Playlist

### What
- An ordered collection of Song objects, represents a user's specific grouping (e.g., “Road Trip”, “Favorites”).

### Why
- People listen to music by mood, genre, activities—playlists enable that freedom and customization.
- Encapsulates song lists, metadata, and provides logic for traversal and management.

### How
- `vector<Song> songs`: Holds the actual Song objects.
- `PlayStrategy playStrategy`: References current strategy (sequential, random, etc.).
- `addSong(Song song)`: User adds a track—key for evolving playlists.
- `hasNext()/next()`: Forwards navigation using playStrategy rules for next song.
- `hasPrevious()/previous()`: Backwards navigation.
- `setPlayStrategy(strategy)`: Changes playback order logic at runtime.
- `setPlaylist(Playlist pl)`: Updates the current playlist.
- *Getters/Setters*: Access and mutation for UI, searching, management.

---

### Playlist Methods (What / Why / How):

| Method                    | What it Does                                  | Why Needed                       | How it Works                          |
|---------------------------|----------------------------------------------|---------------------------------|-------------------------------------|
| `addSong(Song song)`      | Adds a song to this playlist.                 | Build custom playlists.          | Pushes onto internal list/vector.   |
| `hasNext()`               | Checks if more songs remain after current one.| For safe navigation/iteration.   | Compares iterator/index to length.  |
| `next()`                  | Moves to and returns the next song.           | Skipping songs is user-driven.   | Uses playStrategy’s logic.           |
| `hasPrevious()`           | Checks if previous song exists.                | Backtrack through playlist.      | Checks if index > 0.                 |
| `previous()`              | Moves to and returns previous song.            | Backtrack navigation.            | Decrements pointer/index.            |
| `setPlayStrategy(strategy)`| Changes song play order logic.                 | Switch between shuffle/order.    | Sets playStrategy object reference. |
| `setPlaylist(Playlist pl)`| Swap in a new playlist object.                 | Changing what’s being played.    | Assigns playlist variable.           |

---

## 4. Play Strategies (Strategy Pattern)

### a. SequentialPlay
- **What:** Plays songs in the order added.
- **Why:** Default, familiar listening experience.
- **How:** Maintains an index, next() increments linearly through playlist.

### b. RandomPlay
- **What:** Plays songs in random order.
- **Why:** Provides shuffle mode.
- **How:** Randomly selects the next song index amongst unplayed songs.

### How Strategy Pattern Works Here
- Playlist delegates `next()` and `previous()` to the current strategy, allowing easy addition of new strategies without modifying Playlist logic.

---

## 5. PlayState (State Pattern)

### What
- Interface and concrete states for playback status: Playing, Paused, Stopped.

### Why
- Behavior depends on current state (e.g., pause when already paused is ignored).
- Centralizes management of these state-specific behaviors.

### How
- Abstract PlayState defines methods like `play()`, `pause()`.
- Concrete states override these methods for their behavior.
- MusicPlayerFacade holds a reference to current PlayState and calls its methods.

---

## 6. DeviceFactory (Factory Pattern)

### What
- Responsible for creating the output device chosen by the user.

### Why
- Centralizes device creation logic.
- Enables adding new devices without modifying core logic.

### How
- `getDevice(DeviceType type)` returns the appropriate concrete device instance.

---

## 7. Output Devices: BluetoothSpeaker, WiredSpeaker, HeadphonesAdapter

### What
- Classes representing specific audio output hardware.

### Why
- Encapsulate hardware/software handling for each output device.
- Allow easy addition or modification of devices.

### How
- Implement `playSound(Song song)` and other device-specific methods.
- Called by MusicPlayerFacade during playback.

---

# System Flow: Putting It All Together

1. **Startup**  
   MusicPlayerFacade singleton is instantiated; songs and playlists loaded.

2. **Playlist Creation**  
   User calls `createPlaylist(name)`, new playlist added.

3. **Add Songs**  
   User calls `addSong(song)`, song added to selected playlist.

4. **Choose Playback Strategy**  
   User calls `setStrategy()`, e.g., shuffle or sequential.

5. **Select Output Device**  
   User calls `connectDevice()`, device created via DeviceFactory.

6. **Playback**  
   User calls `playSong()` or `playAll()`.
    - PlayState handles play logic.
    - Playlist uses chosen PlayStrategy.
    - Device outputs sound via `playSound()`.

7. **Pause and Navigation**  
   User can pause, resume, skip next/previous songs; state and strategy manage transitions.

---

# Summary Table: What, Why, and How

| Class/Method              | What                                | Why                                  | How                                              |
|--------------------------|-----------------------------------|--------------------------------------|--------------------------------------------------|
| MusicPlayerFacade        | Central control point              | Manage system complexity              | Delegates tasks to subsystems                     |
| createPlaylist           | Makes new playlist                 | Enables organization of songs        | Creates and stores playlist                       |
| addSong                  | Adds song to playlist             | Build dynamic playlists               | Calls Playlist’s addSong                          |
| setStrategy              | Changes playback order            | User listening customization         | Updates Playlist’s playStrategy                   |
| connectDevice            | Selects output device             | Supports multiple devices             | Uses DeviceFactory for creation                   |
| playSong                 | Plays a specific song             | Core feature                         | Interacts with PlayState and output device        |
| pauseSong                | Pauses playback                   | User control                        | Handled by PlayState                              |
| Song                     | Represents individual track        | Fundamental unit                     | Holds metadata, used in playlists and playback    |
| Playlist                 | Groups songs, manages traversal  | Supports user-defined organization  | Holds song list, delegates order to strategy      |
| PlayStrategy             | Defines play order logic         | Flexible playback modes               | Provides `next()` and `previous()` implementation |
| PlayState                | Manages playback states          | Correct response to controls         | State pattern implements different behaviors      |
| DeviceFactory            | Creates device objects            | Decouples device creation            | Returns appropriate device instance               |
| Output Devices           | Output audio                      | Hardware-specific handling           | Implements `playSound()` per device               |

---

# Final Note

This design:
- Uses proven patterns (Singleton, Facade, Factory, Strategy, State) for modularity.
- Enables maintainability and extensibility.
- Creates an easy-to-use interface while handling complex logic internally.

**If you want code examples or further clarifications on any part, feel free to ask!**
