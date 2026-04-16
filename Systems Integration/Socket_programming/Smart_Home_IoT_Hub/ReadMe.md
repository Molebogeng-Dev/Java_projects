**README: Smart Home IoT Hub (Mini-Project)**

**The Mission**
You are building the core local network communication for a Smart Home system. 
The user's mobile app (The Client) will pack a device command(like turning on the living room lights or setting the AC temperature) 
into a JSON box and send it over the local Wi-Fi. 

The central Smart Home Hub (The Server) must receive these commands, handle multiple devices/phones simultaneously, 
"execute" the command, and send a digital status receipt back to the phone.

**The Architecture**
You will need to write four short Java classes for this exercise.

1. 1.Server.DeviceCommand.java (The Blueprint)
2. 2.Client.MobileAppClient.java (The Phone / Client)
3. 3.Server.SmartHubServer.java (The Central Hub / Switchboard)
4. 4.Server.HubWorkerThread.java (The specific worker handling one device's request)

**Step-by-Step Requirements**

1. **Server.DeviceCommand.java**

* Create a simple class with three variables: String deviceId (e.g., "LivingRoomLight"), String action (e.g., "TURN_ON", "SET_TEMP"),
and int targetValue (e.g., 100 for brightness, or 72 for temperature).
* Create a constructor to set these variables when the object is created.

2. **Client.MobileAppClient.java**

* Create a new Server.DeviceCommand object (e.g., set the "BedroomAC" to "SET_TEMP" at 68).
* Use Gson to serialize that command into a JSON text string.
* Create a Socket to connect to "127.0.0.1" on port 7777.
* Use a PrintWriter to send the JSON string down the socket.
* Use a Scanner to listen for the Hub's response, print the response to your console, and then close the socket.

3. **Server.SmartHubServer.java**

* Create a ServerSocket on port 7777.
* Create an infinite while(true) loop.
* Inside the loop, .accept() incoming connections from phones or sensors.
* When a connection is accepted, create a new Server.HubWorkerThread object, pass the connected socket to it, put it in a new Thread, and .start() it.

4. **Server.HubWorkerThread.java**

* Make sure this class implements Runnable.
* It needs a constructor that accepts a Socket passed from the Server.SmartHubServer.
* Inside the run() method:
  * Attach a Scanner to hear the phone.
  * Attach a PrintWriter to talk back to the phone.
  * Read the incoming JSON string and print it to the console (e.g., "Hub received command: {...").
  * Send a simple JSON receipt back to the phone: {"status": "Success", "message": "Device updated"}.