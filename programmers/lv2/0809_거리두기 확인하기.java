class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        for (int i = 0; i < 5; i++){
            boolean result = true;
            for(int j = 0; j < 5; j++){
                for(int s = 0; s < places[i][j].length(); s++){
                    if(s > 0 && s < 4 && j > 0 && j < 4){
                        if(places[i][j].charAt(s) == 'P'){
                            for(int t = 0; t < 4; t++){
                                int ny = j + dy[t];
                                int nx = s + dx[t];

                                if(places[i][ny].charAt(nx) == 'P'){
                                    result = false;
                                    break;
                                }

                                if(places[i][ny].charAt(nx) == 'O'){
                                    if(places[i][j-1].charAt(s-1) == 'P' || places[i][j-1].charAt(s+1) == 'P' || places[i][j+1].charAt(s-1) == 'P' ||
                                        places[i][j+1].charAt(s + 1) == 'P'){
                                        result = false;
                                        break;
                                    }
                                }
                            }
                        }
                        }
                    }
                }
                if(!result){
                    answer[i] = 0;
                    result = true;
                }else {
                    answer[i] = 1;
                }
            }
        
        return answer;
    }
}