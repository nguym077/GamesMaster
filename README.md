# GamesMaster

The x and y with double array way[I][j]


00 10
01 11
02 …(etc)
03
04
05
06
07

Now the way[I][j] will record 4 digit as 4 direction 


    1(up)
4(left)   2(right)
    3(down)


Means
For example:
 way[0][0]= 200, from that point 0,0 it can only go to right 
way[1][4]=34, from that point 14 it can only go to left and down
way[1][4]= 4 from that point 14 it can only go to left
 way[1][4]= 1000, from that point 14 it can only go to up
way[1][4]= 1030, from that point 14 it can only go to up and down
 way[1][4]=1234, from that point 1,4 it can go all the 4 direction.

So when user click moving button, there will be a calculation of way[I][j] to find out the allowable path, can use / and % or other way.
For example if user click up button from point way[3][4]
Then
Way[3][4]/1000,  if equals 1 , it can go up

if user click right button 
(Way[3][4]/100)%10 , if equals 2, it can go right.

If down button
(Way[3][4]/10)%10, if equals 3, it can go down

If left button
Way[3][4]%10, if equals 4, it can go left
