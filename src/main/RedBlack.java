package main;

public class RedBlack {

    public static Node balanceInsertion(Node curr) {
        if (curr.parent == null) {
            curr.color = Node.Color.BLACK;
            return curr;
        }

        Node p = curr.parent;
        if (p.color == Node.Color.BLACK) {
            return balanceInsertion(p);
        }

        Node g = p.parent;
        Node u = getUncle(curr);

        if (p == g.left) {
            u = g.right;
            if (u.color == Node.Color.RED) {
                p.color = Node.Color.BLACK;
                u.color = Node.Color.BLACK;
                g.color = Node.Color.RED;
                return balanceInsertion(g);
            } else {
                if (curr == p.right) {
                    rotateLeft(p);
                    return balanceInsertion(p);
                }
                p.color = Node.Color.BLACK;
                g.color = Node.Color.RED;
                rotateRight(g);
                return balanceInsertion(g);
            }
        } else {
            u = g.left;
            if (u.color == Node.Color.RED) {
                p.color = Node.Color.BLACK;
                u.color = Node.Color.BLACK;
                g.color = Node.Color.RED;
                return balanceInsertion(g);
            } else {
                if (curr == p.left) {
                    rotateRight(p);
                    return balanceInsertion(p);
                }
                p.color = Node.Color.BLACK;
                g.color = Node.Color.RED;
                rotateLeft(g);
                return balanceInsertion(g);
            }

        }


        if (!u.isList && u.color == Node.Color.RED && p.color == Node.Color.RED) {

            p.color = Node.Color.BLACK;
            u.color = Node.Color.BLACK;
            g.color = Node.Color.RED;
            return balanceInsertion(g);
        }

        if (p.right == curr && g.left == p) {

            rotateLeft(p);
            curr = curr.left;
        } else if (curr == p.left && p == g.right) {

            rotateRight(p);
            curr = curr.right;
        }
    }

    p=curr.parent;
    g=p.parent;

    p.color=Node.Color.BLACK;
    if(g!=null)

    {
        g.color = Node.Color.RED;

        if (curr == p.left && p == g.left) {

            rotateRight(g);
        } else {

            rotateLeft(g);
        }
    }

    return

    balanceInsertion(p);

}

    public static Node balanceDeletion(Node curr) {
        if (curr.parent == null) {
            return curr;
        }

        Node s = getBrother(curr);
        Node p = curr.parent;

        if (s.color == Node.Color.RED) {

            p.color = Node.Color.RED;
            s.color = Node.Color.BLACK;

            if (curr == p.left) {

                rotateLeft(p);
            } else {

                rotateRight(p);
            }
        }

        p = curr.parent;
        s = getBrother(curr);
        if (!s.isList) {
            if (p.color == Node.Color.BLACK && s.color == Node.Color.BLACK && s.left.color == Node.Color.BLACK && s.right.color == Node.Color.BLACK) {
                s.color = Node.Color.RED;
                return balanceDeletion(p);
            }

            if (p.color == Node.Color.RED && s.color == Node.Color.BLACK && s.left.color == Node.Color.BLACK && s.right.color == Node.Color.BLACK) {
                s.color = Node.Color.RED;
                p.color = Node.Color.BLACK;
            }

            if (s.color == Node.Color.BLACK) {
                if (curr == p.left && s.right.color == Node.Color.BLACK && s.left.color == Node.Color.RED) {
                    s.color = Node.Color.RED;
                    s.left.color = Node.Color.BLACK;
                    rotateRight(s);
                } else if (curr == p.right && s.right.color == Node.Color.RED && s.left.color == Node.Color.BLACK) {
                    s.color = Node.Color.RED;
                    s.right.color = Node.Color.BLACK;
                    rotateLeft(s);
                }
            }
        } else {

        }

        p = curr.parent;
        s = getBrother(curr);


        s.color = p.color;
        p.color = Node.Color.BLACK;
        if (!s.isList) {
            if (curr == p.left) {
                s.right.color = Node.Color.BLACK;
                rotateLeft(p);
            } else {
                s.left.color = Node.Color.BLACK;
                rotateRight(p);
            }
            return balanceDeletion(s);
        } else {

        }

        return balanceDeletion(p);
    }

    public static Node getUncle(Node curr) {
        Node p = curr.parent;
        if (p.parent.left == p) {

            return p.parent.right;
        } else {

            return p.parent.left;
        }
    }

    public static Node getBrother(Node curr) {
        Node p = curr.parent;
        if (p.left == curr) {
            return p.right;
        } else {

            return p.left;
        }
    }

    public static void rotateLeft(Node x) {
        Node curr = x.right;
        x.right = curr.left;
        curr.left.parent = x;
        curr.parent = x.parent;


        Node g = x.parent;
        if (g != null) {
            if (g.left == x) {
                g.left = curr;
            } else {
                g.right = curr;
            }
        }

        curr.left = x;
        x.parent = curr;
    }

    public static void rotateRight(Node x) {
        Node curr = x.left;
        x.left = curr.right;
        curr.right.parent = x;
        curr.parent = x.parent;

        Node g = x.parent;
        if (g != null) {
            if (g.left == x) {
                g.left = curr;

            } else {

                g.right = curr;
            }
        }
        curr.right = x;
        x.parent = curr;
    }
}
