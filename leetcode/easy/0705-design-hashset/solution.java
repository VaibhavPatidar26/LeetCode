class MyHashSet {
    List<Integer>mp= new ArrayList<>();

    public MyHashSet() {
        this.mp = new ArrayList<>();
    }
    
    public void add(int key) {
          boolean present = false;
        for(int i=0;i<mp.size();i++){
          
            if(mp.get(i)==key){
                present = true;
                break;
            }
        }
        if(present){
            return;
        }else{
            mp.add(key);
        }
    }
    
    public void remove(int key) {
        mp.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        for(int i=0;i<mp.size();i++){
            if(mp.get(i).equals(key)) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */