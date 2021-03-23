package app;

import java.util.*;

public class GraphNode {
    private UserInstance user;
    private List<GraphNode> friends;

    private HashMap<Integer, GraphNode> visited;
    private boolean engaged = false;

    public GraphNode(UserInstance node) {
        user = node;
        friends = new ArrayList<>();
    }

    public UserInstance getUser() {
        return user;
    }

    public List<GraphNode> getFriends() {
        return friends;
    }

    public boolean addRelation(GraphNode incoming_node) {
        boolean isMainNode = this.user.match(incoming_node.getUser());
        boolean alreadyRelated = false;
        for (GraphNode node : friends) {
            if (node.getUser().match(node.getUser())) {
                alreadyRelated = true;
            }
        }

        if (!isMainNode && !alreadyRelated) {
            friends.add(incoming_node);
        }

        return !isMainNode && !alreadyRelated;
    }

    public GraphNode findNode(int id) {
        if (user.getId() == id) {
            return this;
        }

        GraphNode match = this;

        visited = new HashMap<>();
        Queue<GraphNode> staged = new LinkedList<>();

        for (GraphNode node : friends) {
            if (node.getUser().getId() == id) {
                match = node;
                break;
            }
            visited.put(node.getUser().getId(), node);
            staged.add(node);
        }

        GraphNode curr;
        while ((curr = staged.poll()) != null) {
            if (curr.getUser().getId() == id) {
                match = curr;
                break;
            }

            for (GraphNode node : curr.getFriends()) {
                if (visited.get(node.getUser().getId()) == null) {
                    visited.put(node.getUser().getId(), node);
                    staged.add(node);
                }
            }
        }

        return match;
    }
}
