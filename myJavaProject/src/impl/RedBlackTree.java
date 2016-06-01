package impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class RedBlackTree {
	
	static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        volatile V val;
        volatile Node<K,V> next;

        Node(int hash, K key, V val, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public final K getKey()       { return key; }
        public final V getValue()     { return val; }
        public final int hashCode()   { return key.hashCode() ^ val.hashCode(); }
        public final String toString(){ return key + "=" + val; }
        public final V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object o) {
            Object k, v, u; Map.Entry<?,?> e;
            return ((o instanceof Map.Entry) &&
                    (k = (e = (Map.Entry<?,?>)o).getKey()) != null &&
                    (v = e.getValue()) != null &&
                    (k == key || k.equals(key)) &&
                    (v == (u = val) || v.equals(u)));
        }

        /**
         * Virtualized support for map.get(); overridden in subclasses.
         */
        Node<K,V> find(int h, Object k) {
            Node<K,V> e = this;
            if (k != null) {
                do {
                    K ek;
                    if (e.hash == h &&
                        ((ek = e.key) == k || (ek != null && k.equals(ek))))
                        return e;
                } while ((e = e.next) != null);
            }
            return null;
        }
    }
	
	static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c; Type[] ts, as; Type t; ParameterizedType p;
            if ((c = x.getClass()) == String.class) // bypass checks
                return c;
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) {
                    if (((t = ts[i]) instanceof ParameterizedType) &&
                        ((p = (ParameterizedType)t).getRawType() ==
                         Comparable.class) &&
                        (as = p.getActualTypeArguments()) != null &&
                        as.length == 1 && as[0] == c) // type arg is c
                        return c;
                }
            }
        }
        return null;
    }
	
	  @SuppressWarnings({"rawtypes","unchecked"}) // for cast to Comparable
	    static int compareComparables(Class<?> kc, Object k, Object x) {
	        return (x == null || x.getClass() != kc ? 0 :
	                ((Comparable)k).compareTo(x));
	    }
	
	static final class TreeNode<K,V> extends Node<K,V> {
        TreeNode<K,V> parent;  // red-black tree links
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        TreeNode<K,V> prev;    // needed to unlink next upon deletion
        boolean red;

        TreeNode(int hash, K key, V val, Node<K,V> next,
                 TreeNode<K,V> parent) {
            super(hash, key, val, next);
            this.parent = parent;
        }

        Node<K,V> find(int h, Object k) {
            return findTreeNode(h, k, null);
        }

        /**
         * Returns the TreeNode (or null if not found) for the given key
         * starting at given root.
         */
        final TreeNode<K,V> findTreeNode(int h, Object k, Class<?> kc) {
            if (k != null) {
                TreeNode<K,V> p = this;
                do  {
                    int ph, dir; K pk; TreeNode<K,V> q;
                    TreeNode<K,V> pl = p.left, pr = p.right;
                    if ((ph = p.hash) > h)
                        p = pl;
                    else if (ph < h)
                        p = pr;
                    else if ((pk = p.key) == k || (pk != null && k.equals(pk)))
                        return p;
                    else if (pl == null)
                        p = pr;
                    else if (pr == null)
                        p = pl;
                    else if ((kc != null ||
                              (kc = comparableClassFor(k)) != null) &&
                             (dir = compareComparables(kc, k, pk)) != 0)
                        p = (dir < 0) ? pl : pr;
                    else if ((q = pr.findTreeNode(h, k, kc)) != null)
                        return q;
                    else
                        p = pl;
                } while (p != null);
            }
            return null;
        }
    }
	
	  static <K,V> TreeNode<K,V> balanceInsertion(TreeNode<K,V> root,
              TreeNode<K,V> x) {
		  	x.red = true;
		  	for (TreeNode<K,V> xp, xpp, xppl, xppr;;) {
		  		if ((xp = x.parent) == null) {
		  			x.red = false;
		  			return x;
		  		}
		  		else if (!xp.red || (xpp = xp.parent) == null)
		  			return root;
		  		if (xp == (xppl = xpp.left)) {
		  			if ((xppr = xpp.right) != null && xppr.red) {
		  				xppr.red = false;
		  				xp.red = false;
		  				xpp.red = true;
		  				x = xpp;
		  			}
		  			else {
		  				if (x == xp.right) {
		  					root = rotateLeft(root, x = xp);
		  					xpp = (xp = x.parent) == null ? null : xp.parent;
		  				}
		  				if (xp != null) {
		  					xp.red = false;
		  					if (xpp != null) {
		  						xpp.red = true;
		  						root = rotateRight(root, xpp);
		  					}
		  				}
		  			}
		  		}
		  		else {
		  			if (xppl != null && xppl.red) {
		  				xppl.red = false;
		  				xp.red = false;
		  				xpp.red = true;
		  				x = xpp;
		  			}
		  			else {
		  				if (x == xp.left) {
		  					root = rotateRight(root, x = xp);
		  					xpp = (xp = x.parent) == null ? null : xp.parent;
		  				}
		  				if (xp != null) {
		  					xp.red = false;
		  					if (xpp != null) {
		  						xpp.red = true;
		  						root = rotateLeft(root, xpp);
		  					}
		  				}
		  			}
		  		}
		  	}
	  }

	static <K,V> TreeNode<K,V> balanceDeletion(TreeNode<K,V> root,
            TreeNode<K,V> x) {
		for (TreeNode<K,V> xp, xpl, xpr;;)  {
			if (x == null || x == root)
				return root;
			else if ((xp = x.parent) == null) {
				x.red = false;
				return x;
			}
			else if (x.red) {
				x.red = false;
				return root;
			}
			else if ((xpl = xp.left) == x) {
				if ((xpr = xp.right) != null && xpr.red) {
					xpr.red = false;
					xp.red = true;
					root = rotateLeft(root, xp);
					xpr = (xp = x.parent) == null ? null : xp.right;
				}
				if (xpr == null)
					x = xp;
				else {
					TreeNode<K,V> sl = xpr.left, sr = xpr.right;
					if ((sr == null || !sr.red) &&
		(sl == null || !sl.red)) {
						xpr.red = true;
						x = xp;
					}
					else {
						if (sr == null || !sr.red) {
							if (sl != null)
								sl.red = false;
							xpr.red = true;
							root = rotateRight(root, xpr);
							xpr = (xp = x.parent) == null ?
									null : xp.right;
						}
						if (xpr != null) {
							xpr.red = (xp == null) ? false : xp.red;
							if ((sr = xpr.right) != null)
								sr.red = false;
						}
						if (xp != null) {
							xp.red = false;
							root = rotateLeft(root, xp);
						}
						x = root;
					}
				}
			}
			else { // symmetric
				if (xpl != null && xpl.red) {
					xpl.red = false;
					xp.red = true;
					root = rotateRight(root, xp);
					xpl = (xp = x.parent) == null ? null : xp.left;
				}
				if (xpl == null)
					x = xp;
				else {
					TreeNode<K,V> sl = xpl.left, sr = xpl.right;
					if ((sl == null || !sl.red) &&
							(sr == null || !sr.red)) {
						xpl.red = true;
						x = xp;
					}
					else {
						if (sl == null || !sl.red) {
							if (sr != null)
								sr.red = false;
							xpl.red = true;
							root = rotateLeft(root, xpl);
							xpl = (xp = x.parent) == null ?null : xp.left;
						}
						if (xpl != null) {
							xpl.red = (xp == null) ? false : xp.red;
							if ((sl = xpl.left) != null)
								sl.red = false;
						}
						if (xp != null) {
							xp.red = false;
							root = rotateRight(root, xp);
						}
						x = root;
					}
				}
			}
		}
	}

    static <K,V> TreeNode<K,V> rotateLeft(TreeNode<K,V> root,
                                          TreeNode<K,V> p) {
        TreeNode<K,V> r, pp, rl;
        if (p != null && (r = p.right) != null) {
            if ((rl = p.right = r.left) != null)
                rl.parent = p;
            if ((pp = r.parent = p.parent) == null)
                (root = r).red = false;
            else if (pp.left == p)
                pp.left = r;
            else
                pp.right = r;
            r.left = p;
            p.parent = r;
        }
        return root;
    }

    static <K,V> TreeNode<K,V> rotateRight(TreeNode<K,V> root,
                                           TreeNode<K,V> p) {
        TreeNode<K,V> l, pp, lr;
        if (p != null && (l = p.left) != null) {
            if ((lr = p.left = l.right) != null)
                lr.parent = p;
            if ((pp = l.parent = p.parent) == null)
                (root = l).red = false;
            else if (pp.right == p)
                pp.right = l;
            else
                pp.left = l;
            l.right = p;
            p.parent = l;
        }
        return root;
    }

}
