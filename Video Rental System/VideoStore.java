public class VideoStore {
    VideoRentalSystem[] store;

    int checkVideo(String name) {
        int flag = 0;

        for(VideoRentalSystem video:store) {
            if (video.getName().equals(name)) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    void addVideo(String name) {
        int size;
        VideoRentalSystem video = new VideoRentalSystem(name);
        try {
            size = store.length;
        } catch (Exception e) {
            size = 0;
        }
        VideoRentalSystem[] newStore = new VideoRentalSystem[size + 1];
        newStore[size] = video;
        store = newStore;
    }

    void doCheckout(String name) {
        if(store==null || store.length==0) {
            System.out.println("Store is empty");
            return;
        }
        for(VideoRentalSystem video :store) {
            if(video.getName().equals(name)) {
                video.doCheckout();
            }
        }
    }

    void doReturn(String name) {
        if(store==null || store.length==0) {
            System.out.println("Store is empty");
            return;
        }
        for(VideoRentalSystem video :store) {
            if(video.getName().equals(name)) {
                video.doReturn();
            }
        }
    }

    void receiveRating(String name , int rating) {
        if(store==null || store.length==0) {
            System.out.println("Store is empty");
            return;
        }
        for(VideoRentalSystem video :store) {
            if(video.getName().equals(name)) {
                video.receiveRating(rating);
            }
        }
    }

    void listInventory() {
        if (store == null || store.length == 0) {
            System.out.println("Store is empty");
            return;
        }
        for (VideoRentalSystem video : store) {
            System.out.print("**************************************************************************");
            System.out.printf("\n\t%-20s\t|\t%-10s\t|\t%-15s\n", "Video Name","Checkout Status","Rating");
            System.out.printf("\n\t%-20s\t|\t%-10s\t|\t%-15s\n", video.getName(), video.getCheckout(),video.getRating());
            System.out.println("*************************************************************************");
        }
    }

}