# PRiR-Homework_Java_2
## Task 1 - Timepiece
I made a little model view controller (MVC) application that just counts time with threads.\
Also, while the application is running, you can look at the kitten. \
The main class (model) -> ```Czasomierz```, which has the run() method with time calculation. \
Also I did an auxiliary method ```time()``` to print the time on the screen nicer.
### Result
![image](https://user-images.githubusercontent.com/72127610/139556898-b6ad805a-d72a-4de6-b048-61b93950b4e9.png)
![image](https://user-images.githubusercontent.com/72127610/139556934-0065d097-07fe-4d48-a5fd-e8e4fcf9a87d.png)
## Task 2 - Car - class skeleton extension
What I added to this code:
1) Boolean variable - ```java private boolean jazda;```
2) Adding fuel
```java 
public void tankowanie (int _paliwo) {
    this.paliwo += _paliwo;
}
```
3) Car start, we run the thread of fuel consumption.
```java
public void start() {
    jazda = true;
    run();
} 
```
4) Stopping the car, we stop the thread of fuel consumption.
```java
public void stop_s() {
        jazda = false;
        System.out.println("Brak paliwa! Samochod nr-" + nrRej + " zatrzymal sie!");
        tankowanie(pojZbiornika);
        jazda = true;
        System.out.println("Samochod nr-" + nrRej + " odjechal po zatankowaniu.");
}
```
5) Code, that is executed in a separate thread, 1 liter of fuel(50) is used every 1 s of the program. 
```java
public void run() {
  try {
      if (jazda){
          Thread.sleep(1000);
          System.out.println("Samochod nr-" + nrRej + " jedzie! Ilosc paliwa: " + paliwo);
          paliwo -= 50;
          if (paliwo <= 0) {
            stop_s();
          }
      }
  } catch (InterruptedException e) {
      e.printStackTrace();
  }
}
```
6) Main method - I create car array and call the start() method for each one car in this array.
```java
Samochod [] auta = {new Samochod("11Y", 100), new Samochod("12a34", 200),
              new Samochod("1880W", 150), new Samochod("98-12", 250),
              new Samochod("23u32", 50), new Samochod("087-2e", 300)};
while(true) {
  for(Samochod s : auta) {
    s.start();
  }
}
```
![image](https://user-images.githubusercontent.com/72127610/139557251-66399894-8986-449c-a68f-c35080301d9b.png)
## Task 3 - algorithm Monte Carlo
![MonteCarlo2](https://user-images.githubusercontent.com/72127610/139557302-46b1dc39-94f3-466b-9aa2-bb36990b477a.jpg)
![MonteCarlo3](https://user-images.githubusercontent.com/72127610/139557304-a0cb5c45-822e-4d6a-83e2-e4f29dd6a7e7.jpg)
![MonteCarlo](https://user-images.githubusercontent.com/72127610/139557305-8651249b-954b-40a2-bca5-73511a5c216b.jpg)
## Task 4 - Image to negative
![image](https://user-images.githubusercontent.com/72127610/139557343-43000943-fe57-4bd3-b7fe-91450903730b.png)
![image](https://user-images.githubusercontent.com/72127610/139557348-51bda997-a300-493c-ab4f-3557b341343d.png)
## Task 5 - Julia set (fraktal) for more-> resources/Julia!
![image](https://user-images.githubusercontent.com/72127610/139557411-8db31e0b-3e14-4700-b522-739fa01fe3de.png)
## Task 6 - The problem of 5 philosophers
![image](https://user-images.githubusercontent.com/72127610/139557434-9e0e6d18-84f0-4f75-9ce3-84b1c124be9d.png)
