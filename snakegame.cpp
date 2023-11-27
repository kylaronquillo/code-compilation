#include <iostream>
#include <windows.h>
#include <cstdlib>
#include <ctime>
#include <list>
#include <stack>
#include <queue>
#include <conio.h>


using namespace std;

bool gameOver = false;
const int width = 35;
const int height = 15;
int score = 0;

struct snake{
    int x, y;

    snake(int x, int y){
        this->x = x;
        this->y = y;
    }
};

class snakeGame{
private:
    int direction;
    bool gameOver;
    char grid[height][width];
    list<snake>body;
    queue<snake>food;
    stack<snake>move;
    char part = 'o';

public:

    // store characters on the 2d array grid
    void makeGameGrid(){
         for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    grid[i][j] = '#';
                } else {
                    grid[i][j] = ' ';
                }
            }
        }
    }

    //spawnn a snack for the snake then push it to the queue
    void spawn_a_snack(){
        srand(time(0));

        int x, y;
        do {
            x = rand() % width;
            y = rand() % height;
        } while (grid[x][y] != ' ');

        food.push(snake(x, y));
        grid[x][y] = '*';  
    }

    // display the 2d array used 
    void displayGameGrid(){
        system("cls");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cout << grid[i][j];
            }
            cout << endl;
        }
    }
    
    void inputDirection() {
        if (_kbhit()) {
            char key = _getch();
            switch (key) {
                case 'w':
                case 'W':
                case 72: // Up
                    direction = 1;
                    break;
                case 's':
                case 'S':
                case 80: // Down
                    direction = 2;
                    break;
                case 'a':
                case 'A':
                case 75: // Left 
                    direction = 3;
                    break;
                case 'd':
                case 'D':
                case 77: // Right
                    direction = 4;
                    break;
                case 'x':
                case 'X':
                    gameOver = true;
                    break;
            }
        }
    }
    void moveSnake(){
        snake head = body.front();
        snake dirHead =  head;

        switch(direction){
            case 1:
                dirHead.y--;
                break;
            case 2:
                dirHead.y++;
                break;
            case 3:
                dirHead.x--;
                break;
            case 4:
                dirHead.x++;
                break; 
        }
    }

    void snakeBody(){
        snake head = body.front();
        body.push_front(snake(head.x, head.y));

        if (!body.empty()) {
            snake tail = body.back();
            body.pop_back();
            grid[tail.x][tail.y] = ' ';
        }
    }



};

int main(){
    snakeGame s;
    s.makeGameGrid();
    s.spawn_a_snack();
    s.displayGameGrid();

    while(!gameOver){
        s.inputDirection();
        s.moveSnake();
        s.displayGameGrid();
    }

    cout << "GAME OVER!\n";
    cout << "Score: " << score;

    return 0;
    
}   
