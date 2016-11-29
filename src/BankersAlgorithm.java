/**
 * Created by Damindu on 11/28/2016.
 */
public class BankersAlgorithm {
    final int PROCESS = 5;
    final int RESOURCES = 4;

    int[] work;
    int[] available;
    int[][] max;
    boolean[] finish;
    int[][] need;
    private int[][] allocated;

    public BankersAlgorithm(Inputs input){
        this.work = input.getWork();
        this.available = input.getAvailable();
        this.max = input.getMax();
        this.finish = input.getFinish();
        this.need = input.getNeed();
        this.allocated = input.getAllocated();
    }

    public void main(){
        resetAllToUnfinish();
        searchAndFinish();
        if(checkFinish() == false)
            System.out.println("No deadlocks");
        else
            System.out.println("Deadlocks possible");
    }

    /**
     * Release resources to work array from the finished
     * process
     * @param i
     */
    private void releaseResources(int i){
        for(int j=0; j<RESOURCES; j++){
            this.work[j] += this.allocated[i][j];
        }
    }

    /**
     * Resets finish array to all false.
     */
    private void resetAllToUnfinish(){
        for(int i=0; i<PROCESS; i++){
            this.finish[i] = false;
        }
    }



    private void searchAndFinish(){
        for(int i=0; i<PROCESS; i++){
            if(checkNeedOfProcess(i) == true){
                releaseResources(i);
                this.finish[i] = true;
            }
        }
    }

    /**
     * Check needed array of i process. If every work element is
     * lower than needed amount the request can be give. Hence it
     * returns true.
     * @param i
     * @return
     */
    private boolean checkNeedOfProcess(int i){
        int count = 1;
        for(int j=0; j<RESOURCES; j++){
            if(need[i][j] > work[j])
                return false;
        }
        return true;
    }

    private boolean checkFinish(){
        for(int i=0; i<PROCESS; i++)
            if(this.finish[i] == false)
                return false;
        return true;
    }
}
