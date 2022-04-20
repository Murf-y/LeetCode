class Solution {
    public int romanToInt(String s) {
          int sum = 0;
          int pointer = 0;
          while(pointer < s.length()){
              String current = String.valueOf(s.charAt(pointer));
              String next = "";
              if(pointer+1 < s.length()){
                  next = String.valueOf(s.charAt(pointer+1));
                }
              if(current.equals("I")){
                  if(next.equals("V")){
                      sum += 4;
                      pointer += 1;
                  }
                  else if(next.equals("X")){
                      sum += 9;
                      pointer += 1;
                  }
                  else{
                      int total = 0;
                      for(int i = pointer; i < s.length(); i++){
                          String c = String.valueOf(s.charAt(i));
                          if(c.equals("I")){
                              total +=1;
                              pointer += 1;
                          }else{
                              break;
                          }
                      }
                      pointer -=1;
                      sum += total;
                  }
              }
              else if(current.equals("V")){
                  sum += 5;
              }
              else if(current.equals("M")){
                  sum += 1000;
              }
              else if(current.equals("L")){
                  sum += 50;
              }
              else if(current.equals("D")){
                  sum += 500;
              }
              else if(current.equals("X")){
                  if(next.equals("L")){
                      sum += 40;
                      pointer += 1;
                  }
                  else if(next.equals("C")){
                      sum += 90;
                      pointer += 1;
                  }
                  else{
                      int total = 0;
                      for(int i = pointer; i < s.length(); i++){
                          String c = String.valueOf(s.charAt(i));
                          if(c.equals("X")){
                              total +=10;
                              pointer +=1;
                          }else{
                              break;
                          }
                      }
                      pointer -=1;
                      sum += total;
                  }
              }
              else if(current.equals("C")){
                  if(next.equals("D")){
                      sum += 400;
                      pointer += 1;
                  }
                  else if(next.equals("M")){
                      sum += 900;
                      pointer += 1;
                  }
                  else{
                      int total = 0;
                      for(int i = pointer; i < s.length(); i++){
                          String c = String.valueOf(s.charAt(i));
                          if(c.equals("C")){
                              total +=100;
                              pointer +=1;
                          }else{
                              break;
                          }
                      }
                      pointer -=1;
                      sum += total;
                  }
              }
              pointer += 1;
          }
          return sum;
      }
}