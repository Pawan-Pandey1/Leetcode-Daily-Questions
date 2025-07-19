class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> folderSet=new HashSet<>();
        for(String folderPath:folder){
            folderSet.add(folderPath);
        }
        List<String>result=new ArrayList<>();
        for(String currFolder:folder){
            boolean isSubfolder=false;
            String tempFolder=currFolder;

            while(!currFolder.isEmpty()){
                int position=currFolder.lastIndexOf('/');
                if(position==-1) break;
                currFolder=currFolder.substring(0,position);

                if(folderSet.contains(currFolder)){
                    isSubfolder=true;
                    break;
                }
            }
            if(!isSubfolder){
                result.add(tempFolder);
            }
        }
        return result;
    }
}