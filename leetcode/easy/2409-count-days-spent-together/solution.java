class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int days[] = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
             StringBuilder  AliceArriveMonth = new StringBuilder();
             StringBuilder  AliceArriveDay = new StringBuilder();
             StringBuilder  BobArriveMonth = new StringBuilder();
             StringBuilder  BobArriveDay = new StringBuilder();;
             StringBuilder  AliceLeaveDay = new StringBuilder();
             StringBuilder  AliceLeaveMonth = new StringBuilder();
             StringBuilder BobLeaveDay = new StringBuilder();
             StringBuilder BobLeaveMonth = new StringBuilder();
        for(int i=0;i<arriveAlice.length();i++){
           
            if(i<2){
                AliceArriveMonth.append(arriveAlice.charAt(i));
                AliceLeaveMonth.append(leaveAlice.charAt(i));
                BobArriveMonth.append(arriveBob.charAt(i));
                BobLeaveMonth.append(leaveBob.charAt(i));

            }
            else if(i>2){
                AliceArriveDay.append(arriveAlice.charAt(i));
                AliceLeaveDay.append(leaveAlice.charAt(i));
                BobArriveDay.append(arriveBob.charAt(i));
                BobLeaveDay.append(leaveBob.charAt(i));
            }
        }
        int alcArrMon = Integer.parseInt(AliceArriveMonth.toString());
        int alcArrDay = Integer.parseInt(AliceArriveDay.toString());
        int alcLeaveDay = Integer.parseInt(AliceLeaveDay.toString());
        int alcLeaveMon = Integer.parseInt(AliceLeaveMonth.toString());
        int BobArrMon = Integer.parseInt(BobArriveMonth.toString());
        int BobLeaveMon = Integer.parseInt(BobLeaveMonth.toString());
        int BobArrDay = Integer.parseInt(BobArriveDay.toString());
        int BobLveDay = Integer.parseInt(BobLeaveDay.toString());

        int AliceArriveYearDay = alcArrDay;
        for(int i=1;i<alcArrMon;i++){
            AliceArriveYearDay += days[i];
        }
        int AliceLeaveYearDay = alcLeaveDay;
        for(int i=1;i<alcLeaveMon;i++){
            AliceLeaveYearDay+=days[i];
        }
        int BobArriveYearDay = BobArrDay;
        for(int i=1;i<BobArrMon;i++){
            BobArriveYearDay+=days[i];
        }
        int BobLeaveYearDay = BobLveDay;
        for(int i=1;i<BobLeaveMon;i++){
            BobLeaveYearDay +=days[i];
        }
        System.out.print(AliceArriveYearDay + " ");
        System.out.print(AliceLeaveYearDay+" ");
        System.out.print(BobArriveYearDay+" ");
        System.out.print(BobLeaveYearDay);

//248 251
// 249  252


int start = Math.max(AliceArriveYearDay, BobArriveYearDay);
int end = Math.min(AliceLeaveYearDay, BobLeaveYearDay);

return Math.max(0, end - start + 1);

        

    }
}