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
## Task 3 - algorithm Monte Carlo (radius = 235)
I made a model view controller (MVC) application, which counts the area of a circle using the Monte Carlo algorithm and visualizes this circle with random points. \
I had to do it with threads, so I divided the area (i.e. a square) into four parts (four threads). \
Each of the threads(4) draws a certain number of random points in its part, which the user provides. \
I made an auxiliary ```Punkt()``` method to make it easier to store these random points. \
Action:
```java
int begin_x = 1, end_x = 1;
int begin_y = 1, end_y = 1;
// x[1; 235]y[1;235]
if (numer == 0) {
    begin_x = 1;
    end_x = 235;
    begin_y = 1;
    end_y = 235;
}
...
for(int i = 0; i <= sum_points; i++){
    pointX = rand.nextInt(end_x-begin_x) + begin_x; 
    pointY = rand.nextInt(end_y-begin_y) + begin_y;
    // System.out.println(new Punkt(pointX, pointY));
    points.add(new Punkt(pointX, pointY));
    if (Math.sqrt((pointX - 470) * (pointX - 470) + (pointY - 470) * (pointY - 470)) <= 235) {
        result++;
    }     
}
```
1) The user specifies the number of random points. 
2) Run() method: 
One thread (e.g. 1 part of a square) generates x and y coordinates for these points using the Random class (NextInt method). \
Adds the points to the ArrayList and further checks by a circle equation to see, if that point is in the circle. \
If so, it increments the variable ```result```. 
3) Calling threads in the class ```SimModel``` 
Correctness of the result using a formula : Area = (result(points in the circle)*area_of_rectangle)/number of random points
```java
...
result = thread0.getResult() + thread1.getResult() + 
				thread2.getResult() + thread3.getResult();
result = (result*Math.pow(470, 2))/sum_points;
...
```
4) Drawing points in class ```SimView```
```java
...
p = SimModel.getPoints();
for(Punkt pn: p) {
    g2d.fillOval(pn.getX(), pn.getY(), 2, 2);
}
...
```
### Result for points = 1000
![MonteCarlo2](https://user-images.githubusercontent.com/72127610/139557302-46b1dc39-94f3-466b-9aa2-bb36990b477a.jpg)
![MonteCarlo3](https://user-images.githubusercontent.com/72127610/139557304-a0cb5c45-822e-4d6a-83e2-e4f29dd6a7e7.jpg)
![MonteCarlo](https://user-images.githubusercontent.com/72127610/139557305-8651249b-954b-40a2-bca5-73511a5c216b.jpg)
![image](https://user-images.githubusercontent.com/72127610/139558720-f00d06c4-406c-4a06-be96-70414f3b8948.png)

## Task 4 - Image to negative
The principle of operation(code) the same as in the previous program. \
Dividing the image into four threads, i.e. into four parts. \
Each thread in its area changes the RGB pixel color. \
Also, I made an auxiliary class ```Pixel``` to make it easier to store information about changed pixels. \
```java
negativeImage thread0 = new negativeImage(0);
negativeImage thread1 = new negativeImage(1);
negativeImage thread2 = new negativeImage(2);
negativeImage thread3 = new negativeImage(3);

thread0.start();
thread1.start();
thread2.start();
thread3.start();

thread0.join();
thread1.join();
thread2.join();
thread3.join();

ArrayList <Pixel> res_p = new ArrayList<>();
res_p.addAll(thread0.getPexel());
res_p.addAll(thread1.getPexel());
res_p.addAll(thread2.getPexel());
res_p.addAll(thread3.getPexel());

...
// change image to negative
for(Pixel p : res_p) {
    image.setRGB(p.getJ(), p.getI(), p.getColor().getRGB());
}
...
```
![image](https://user-images.githubusercontent.com/72127610/139557343-43000943-fe57-4bd3-b7fe-91450903730b.png)
![image](https://user-images.githubusercontent.com/72127610/139557348-51bda997-a300-493c-ab4f-3557b341343d.png)
## Task 5 - Julia set (fraktal) for more-> resources/Julia! - class skeleton extension
What I added to this code:\
1) Color change.
```java
// 1) red 3) blue
Color c = new Color(0, 0, level);  
img.setRGB(i, j, c.getRGB());
```
2) I have generated more than one image.
```java
ImageIO.write(img, "PNG", new File("src/resources/julia/Julia_crystal.png"));
/*
ImageIO.write(img, "PNG", new File("src/resources/julia/Julia_snowflake.png"));
ImageIO.write(img, "PNG", new File("src/resources/julia/Julia_8.png"));
ImageIO.write(img, "PNG", new File("src/resources/julia/Julia_koronawirus.png"));
ImageIO.write(img, "PNG", new File("src/resources/julia/Julia_spirall.png"));
*/
```
3) Method run(); Pick some values for the constant c, this determines the shape of the Julia Set.
```java
// snowflake
/*
double cRe = -0.70176;
double cIm = -0.3842;
*/
// 8
/*
double cRe = 0.285;
double cIm = 0.01;
*/
// koronawirus
/*
double cRe = -0.8;
double cIm = 0.156;
*/
// crystal
/**/
double cRe = -0.62772;
double cIm = 0.42193;

// spirall
/*
double cRe = -0.7709787;
double cIm = 0.08545;
*/
```
4) Change of this part due to a different formula for Julia set.
```java
...
while (k < CUTOFF && zr * zr + zi * zi < 4.0) {
	double newr = zr*zr - zi*zi + cRe;
	double newi = 2*zr*zi + cIm;
...
```
### Result - fractal as figure eight
![image](https://user-images.githubusercontent.com/72127610/139557411-8db31e0b-3e14-4700-b522-739fa01fe3de.png)
## Task 6 - The problem of 5 philosophers
I connected these 3 implementations in the ```main``` class. \
I made a static ```menu()``` method, in which the user can choose one of the implementations of the problem of 5 philosophers. \
Method ```sprawdzOpcje()``` checking the correctness of the entered selection. \
Method ```setNumFiloz()``` gives the user the opportunity to enter the number of philosophers in the simulation.
![image](https://user-images.githubusercontent.com/72127610/139557434-9e0e6d18-84f0-4f75-9ce3-84b1c124be9d.png)
