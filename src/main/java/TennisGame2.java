
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (P1point == P2point)
        {
            if (P1point < 3) {
                score = calculateRes(P1point) + "-All";
            }
            else {
                score = "Deuce";
            }
        }
        P1res = calculateRes(P1point);
        P2res = calculateRes(P2point);
        
        if ((P1point>P2point && P1point < 4)||(P2point>P1point && P2point < 4))
        {
            score = P1res + "-" + P2res;
        }
        
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (P1point>=4 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }
    
    public void SetP1Score(int number){
        
        P1point = number;
            
    }
    
    public void SetP2Score(int number){

        P2point = number;
            
    }

    public String calculateRes(int number) {
        return switch (number) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
    }
}