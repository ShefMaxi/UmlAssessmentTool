class Position
{

    Position(int row_, int column_)
    {
        row = row_;
        column = column_;
    }

    public boolean equals(Position position)
    {
        return (position.row == row && position.column == column);
    }

    public static Position ahead(Position pos, int direction)
    {
        Position newPos = new Position(pos.row, pos.column);
        switch (direction)
        {
            case 1 :
                newPos.row += 1;
                break;
            case 2 :
                newPos.column += 1;
                break;
            case 3 :
                newPos.row -= 1;
                break;
            case 4 :
                newPos.column -= 1;
                break;
        }
        return newPos;
    }

    public int row;
    public int column;
}