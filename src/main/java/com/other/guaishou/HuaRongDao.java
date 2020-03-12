package com.other.guaishou;

import java.util.*;

public class HuaRongDao {


    //1 卒 2 竖将 3 横将 4 曹操

    //是否结束
    public boolean isEnd(HrdGameState state) {
        Warrior cc = state.heroes.get("曹操");

        if (cc.left == 2 && cc.top == 4) {
            return true;
        }


        return false;
    }


    //判断武将是否可以移动
    public boolean canHeroMove(HrdGameState state, String heroName, Directions dir) {
        boolean canMove = false;

        Warrior warrior = state.heroes.get(heroName);

        switch (warrior.type) {
            case 1:

                canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY()] == 0;
                break;
            case 2:
                if (dir == Directions.UP) {
                    canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY()] == 0;
                } else if (dir == Directions.DOWN) {
                    canMove = state.board[warrior.top + dir.getX() + 1][warrior.left + dir.getY()] == 0;
                } else if (dir == Directions.LEFT) {
                    canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY()] == 0 && state.board[warrior.top + dir.getX() + 1][warrior.left + dir.getY()] == 0;
                } else if (dir == Directions.RIGHT) {
                    canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY()] == 0 && state.board[warrior.top + dir.getX() + 1][warrior.left + dir.getY()] == 0;
                }
                break;
            case 3:
                if (dir == Directions.UP) {
                    canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY()] == 0 && state.board[warrior.top + dir.getX()][warrior.left + dir.getY() + 1] == 0;
                } else if (dir == Directions.DOWN) {
                    canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY()] == 0 && state.board[warrior.top + dir.getX()][warrior.left + dir.getY() + 1] == 0;
                } else if (dir == Directions.LEFT) {
                    canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY()] == 0;
                } else if (dir == Directions.RIGHT) {
                    canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY() + 1] == 0;
                }
                break;
            case 4:
                switch (dir) {
                    case UP:
                        canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY()] == 0 && state.board[warrior.top + dir.getX()][warrior.left + dir.getY() + 1] == 0;
                        break;
                    case DOWN:
                        canMove = state.board[warrior.top + dir.getX() + 1][warrior.left + dir.getY()] == 0 && state.board[warrior.top + dir.getX() + 1][warrior.left + dir.getY() + 1] == 0;
                        break;
                    case LEFT:
                        canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY()] == 0 && state.board[warrior.top + dir.getX() + 1][warrior.left + dir.getY()] == 0;
                        break;
                    case RIGHT:
                        canMove = state.board[warrior.top + dir.getX()][warrior.left + dir.getY() + 1] == 0 && state.board[warrior.top + dir.getX() + 1][warrior.left + dir.getY() + 1] == 0;
                        break;
                }

                break;
            default:
                canMove = false;
                break;
        }


        return canMove;
    }


    // 移动棋子到新的位置
    public HrdGameState moveHeroMoveNewState(HrdGameState state, String heroName, Directions dir) {

        HrdGameState newState = null;
        if (canHeroMove(state, heroName, dir)) {
            newState = state.clone();

            Warrior warrior = newState.heroes.get(heroName);
            makeBoard(newState, warrior, dir);
            warrior.top = warrior.top + dir.getX();
            warrior.left = warrior.left + dir.getY();

            newState.step = state.step + 1;
            newState.parent = state;

            MoveAction ma = new MoveAction();
            ma.heroName = heroName;
            ma.dir = dir;
            newState.moveAction = ma;
        }


        return newState;
    }


    // 产生新的棋盘
    public void makeBoard(HrdGameState newState, Warrior warrior, Directions dir) {
        switch (warrior.type) {
            case 1:

                newState.board[warrior.top][warrior.left] = 0;
                newState.board[warrior.top + dir.getX()][warrior.left + dir.getY()] = warrior.type;
                break;
            case 2:
                //printArray(newState.board);
                switch (dir) {
                    case UP:
                        newState.board[warrior.top + 1][warrior.left] = 0;
                        newState.board[warrior.top - 1][warrior.left] = warrior.type;
                        break;
                    case DOWN:
                        newState.board[warrior.top][warrior.left] = 0;
                        newState.board[warrior.top + 2][warrior.left] = warrior.type;
                        break;
                    case LEFT:
                        newState.board[warrior.top][warrior.left] = 0;
                        newState.board[warrior.top + 1][warrior.left] = 0;
                        newState.board[warrior.top][warrior.left - 1] = warrior.type;
                        newState.board[warrior.top + 1][warrior.left - 1] = warrior.type;
                        break;
                    case RIGHT:
                        newState.board[warrior.top][warrior.left] = 0;
                        newState.board[warrior.top + 1][warrior.left] = 0;
                        newState.board[warrior.top][warrior.left + 1] = warrior.type;
                        newState.board[warrior.top + 1][warrior.left + 1] = warrior.type;
                        break;
                    default:
                        break;
                }
                //printArray(newState.board);
                break;
            case 3:
                switch (dir) {
                    case UP:
                        newState.board[warrior.top][warrior.left] = 0;
                        newState.board[warrior.top][warrior.left + 1] = 0;
                        newState.board[warrior.top - 1][warrior.left] = warrior.type;
                        newState.board[warrior.top - 1][warrior.left + 1] = warrior.type;
                        break;
                    case DOWN:
                        newState.board[warrior.top][warrior.left] = 0;
                        newState.board[warrior.top][warrior.left + 1] = 0;
                        newState.board[warrior.top + 1][warrior.left] = warrior.type;
                        newState.board[warrior.top + 1][warrior.left + 1] = warrior.type;
                        break;
                    case LEFT:
                        newState.board[warrior.top][warrior.left + 1] = 0;
                        newState.board[warrior.top][warrior.left - 1] = warrior.type;
                        break;
                    case RIGHT:
                        newState.board[warrior.top][warrior.left] = 0;
                        newState.board[warrior.top][warrior.left + 2] = warrior.type;
                        break;
                    default:
                        break;
                }

                break;
            case 4:

                switch (dir) {
                    case UP:
                        newState.board[warrior.top - 1][warrior.left] = 0;
                        newState.board[warrior.top - 1][warrior.left + 1] = 0;
                        newState.board[warrior.top + 1][warrior.left] = warrior.type;
                        newState.board[warrior.top + 1][warrior.left + 1] = warrior.type;
                        break;
                    case DOWN:
                        newState.board[warrior.top][warrior.left] = 0;
                        newState.board[warrior.top][warrior.left + 1] = 0;
                        newState.board[warrior.top + 2][warrior.left] = warrior.type;
                        newState.board[warrior.top + 2][warrior.left + 1] = warrior.type;
                        break;
                    case LEFT:
                        newState.board[warrior.top][warrior.left + 1] = 0;
                        newState.board[warrior.top + 1][warrior.left + 1] = 0;
                        newState.board[warrior.top][warrior.left - 1] = warrior.type;
                        newState.board[warrior.top + 1][warrior.left - 1] = warrior.type;
                        break;
                    case RIGHT:
                        newState.board[warrior.top][warrior.left] = 0;
                        newState.board[warrior.top + 1][warrior.left] = 0;

                        newState.board[warrior.top][warrior.left + 2] = warrior.type;
                        newState.board[warrior.top + 1][warrior.left + 2] = warrior.type;
                        break;
                    default:
                        break;
                }


                break;
            default:

                break;
        }
    }


    //判断 棋盘是否存在
    List<HrdGameState> states = new ArrayList<>();


    public boolean isExitBoard(HrdGameState currentState) {
        int[][] board = currentState.board;

        boolean flag = true;
        for (HrdGameState state : states) {
            int[][] bd = state.board;

            flag = Arrays.deepEquals(board, bd);

            if (flag) {

                return true;
            }
        }

        return false;
    }


    TreeSet<String> ds = new TreeSet();

    public boolean isExitBoard2(HrdGameState currentState) {
        int[][] board = currentState.board;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 5; j++) {
                sb.append(board[i][j]);
            }
        }


        String s = sb.toString();

        if (ds.contains(s)) {

            return true;
        } else {
            ds.add(s);

            return false;
        }


    }

    public List<HrdGameState> search(HrdGameState startState) {
        List<HrdGameState> sucessState = new ArrayList<>();


        states.add(startState);

        int start = 0;
        int end = 0;

        int len = 1;

        int level = 0;
        while (len > 0) {

            level++;
            System.out.println(level);
            System.out.println(sucessState.size());

            System.out.println(states.size());
            System.out.println();


            start = end;
            end = start + len;
            len = 0;
            for (int i = start; i < end; i++) {
                HrdGameState state = states.get(i);
                for (String horeName : state.heroes.keySet()) {
                    for (Directions dir : Directions.values()) {
                        HrdGameState hrdGameState = moveHeroMoveNewState(state, horeName, dir);
                        if (hrdGameState != null && !isExitBoard2(hrdGameState)) {

                            if (isEnd(hrdGameState)) {
                                sucessState.add(hrdGameState);
                            } else {
                                len++;
                                states.add(hrdGameState);

                            }

                            // 连续问题


                        }
                    }

                }


            }

        }


        return sucessState;
    }



    public static void main(String[] args) {
        HrdGameState startState = new HrdGameState();

        int[][] board = new int[][]{
                {15, 15, 15, 15, 15, 15},
                {15, 2, 4, 4, 2, 15},
                {15, 2, 4, 4, 2, 15},
                {15, 2, 3, 3, 2, 15},
                {15, 2, 1, 1, 2, 15},
                {15, 1, 0, 0, 1, 15},
                {15, 15, 15, 15, 15, 15},
        };
        Map<String, Warrior> heroes = new HashMap<>();
        Warrior hero1 = new Warrior("张飞", 2, 1, 1);
        heroes.put(hero1.name, hero1);
        Warrior hero2 = new Warrior("曹操", 4, 1, 2);
        heroes.put(hero2.name, hero2);
        Warrior hero3 = new Warrior("赵云", 2, 1, 4);
        heroes.put(hero3.name, hero3);
        Warrior hero4 = new Warrior("马超", 2, 3, 1);
        heroes.put(hero4.name, hero4);
        Warrior hero5 = new Warrior("关羽", 3, 3, 2);
        heroes.put(hero5.name, hero5);
        Warrior hero6 = new Warrior("卒1", 1, 4, 2);
        heroes.put(hero6.name, hero6);
        Warrior hero7 = new Warrior("卒2", 1, 4, 3);
        heroes.put(hero7.name, hero7);
        Warrior hero8 = new Warrior("黄忠", 2, 3, 4);
        heroes.put(hero8.name, hero8);
        Warrior hero9 = new Warrior("卒3", 1, 5, 1);
        heroes.put(hero9.name, hero9);
        Warrior hero10 = new Warrior("卒4", 1, 5, 4);
        heroes.put(hero10.name, hero10);


        startState.board = board;
        startState.heroes = heroes;

        startState.step = 0;

        HuaRongDao h = new HuaRongDao();

        List<HrdGameState> sucessState = h.search(startState);

        System.out.println(sucessState.size());
        System.out.println(h.states.size());

        for (HrdGameState hrdGameState : sucessState) {
            System.out.println(hrdGameState.step);
            h.printArray(hrdGameState.board);
        }

    }


    public void printArray(int[][] array) {
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

}

enum Directions {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private int x;
    private int y;

    Directions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Warrior {
    public String name;
    public int type;
    public int left;
    public int top;

    public Warrior(String name, int type, int top, int left) {
        this.name = name;
        this.type = type;
        this.left = left;
        this.top = top;
    }

    @Override
    protected Warrior clone() {
        return new Warrior(this.name, this.type, this.top, this.left);
    }
}

class MoveAction {
    public String heroName;
    public Directions dir;
}

class HrdGameState {
    public int[][] board;
    public Map<String, Warrior> heroes;
    public MoveAction moveAction;
    public int step;
    public HrdGameState parent;
    //public boolean isEnd = false;

    @Override
    protected HrdGameState clone() {
        HrdGameState state = new HrdGameState();

        //state.board = this.board.clone();
        state.board = new int[7][];
        for (int i = 0; i < 7; i++) {
            state.board[i] = this.board[i].clone();
        }
        //state.board = Arrays.copyOf(this.board,7);

        state.heroes = new HashMap<>();
        for (Map.Entry<String, Warrior> entry : this.heroes.entrySet()) {
            state.heroes.put(entry.getKey(), entry.getValue().clone());
        }
        //state.heroes = this.heroes;


        return state;

    }
}

