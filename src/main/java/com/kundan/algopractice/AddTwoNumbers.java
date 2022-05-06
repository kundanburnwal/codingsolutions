package com.kundan.algopractice;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author kundan
 *
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * L1: 2 => 4 => 3
 * L2: 5 => 6 => 4
 * R : 7 => 0 => 8
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		//[9,9,9,9,9,9,9]
		//[9,9,9,9]
		//ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
		//ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
		
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

		ListNode res = new AddTwoNumbers().addTwoNumbers(l1, l2);
		while (res != null) {
			System.out.print(res.val+" => ");
			res = res.next;
		}
	}

	
	 //Definition for singly-linked list.
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	    public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
	        ListNode h1 = l1;
	        ListNode h2 = l2;
	        ListNode h3 = null;
	        ListNode first = null;
	        int i = 0;
	        while (h1 != null || h2 !=null) {
	        	int digit = 0, carry = 0, r = 0;

	        	if (h1!=null && h2 !=null) {
	                r = h1.val + h2.val; 
	            } else if(h1 == null) {
	                r = h2.val;
	            } else if(h2 == null) {
	                r = h1.val;
	            } 
	            if (h3 != null) {
	            	r += h3.val;
	            }
	            if (r >= 10) {
	                digit = r % 10;
	                carry = 1;
	            } else {
	                digit = r;
	            }
	            StringBuilder sb = new StringBuilder("iteration="+i+" h1=");
	            sb.append(h1 != null ? h1.val : null)
	              .append(" h2=")
	              .append(h2 != null ? h2.val : null)
	              .append(" digit="+digit+" carry="+carry);
	            System.out.print(sb.toString());
	            boolean isLastNode = ((h1 == null || h1.next ==null) && (h2 ==null ||h2.next==null));
	            
	            ListNode carryOverNextNode = (carry > 0 || !isLastNode )  ? new ListNode(carry) : null;
	            if (first == null) {
	            	first = new ListNode(digit, carryOverNextNode);
	            	h3 = first;
		            System.out.println(" node created="+h3.val+" next="+(h3.next != null? h3.next.val : null));
		            h3 = h3.next;
	            } else {
	            	h3.val = digit;
	            	h3.next = carryOverNextNode;
	            	System.out.println(" node updated="+h3.val+" next="+(h3.next != null? h3.next.val : null));
	            	h3 = h3.next;
	            }
	            
	   
                if (h1 != null) {
                	h1 = h1.next;    
                }
                if (h2 != null) {
                	h2 = h2.next;
                }
                i++;
	        }
	        return first;
	}
}
