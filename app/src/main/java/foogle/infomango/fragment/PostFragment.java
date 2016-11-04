package foogle.infomango.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class PostFragment extends PostListFragment{

    public PostFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        return databaseReference.child("user-posts")
                .child(getUid());
    }
}
