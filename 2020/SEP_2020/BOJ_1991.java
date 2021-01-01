import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1991 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		
		for (int i = 0; i < num; i++) {
			String st[] = br.readLine().split(" ");
			tree.add(st[0].charAt(0), st[1].charAt(0), st[2].charAt(0));
		}
		
		Tree.preorder(tree.root);
		System.out.println();
		Tree.inorder(tree.root);
		System.out.println();
		Tree.postorder(tree.root);
	}
}

class Node {
	char data;
	Node left, right;
	
	public Node(char data) { 
		this.data = data; 
	}
}
class Tree {
	Node root;
	public void add(char data, char left, char right) {
		if (root == null) {
			if (data != '.') {
				root = new Node(data);
			}
			if (left != '.') {
				root.left = new Node(left);
			}
			if (right != '.') {
				root.right = new Node(right);
			}
		}
		else {
			next(root, data, left, right);
		}
	}
	private void next (Node root, char data, char left, char right){
	    if (root == null) {
	    	return;
	    }
	    
	    else if (root.data == data) {
		    if (left != '.') {
		    	root.left = new Node(left);
		    }
		    if(right != '.') {
		    	root.right = new Node(right);
		    }
	    }
	    
	    else{
		    next(root.left, data, left, right);
		    next(root.right, data, left, right);
	    }
    }
	
	public static void preorder (Node root){
		System.out.print(root.data);
		
		if (root.left != null) {
			preorder(root.left);
		}
		
		if (root.right != null) {
			preorder(root.right);
		}
	}
	
	public static void inorder(Node root) {
		if(root.left != null) {
			inorder(root.left);
		}
		
		System.out.print(root.data);
		
		if(root.right != null) {
			inorder(root.right);
		}
	}
	
	public static void postorder(Node root) {
		if(root.left != null) {
			postorder(root.left);
		}
		
		if(root.right != null) {
			postorder(root.right);
		}
		
		System.out.print(root.data);
	}
}