# Question
Given a set of words, count minimum number of steps required to convert one word into another word satisfying the following conditions,
1.	At any time, we are allowed only to change or insert or remove a single character in the word.
2.	The resultant word obtained in step 1 should also be present in the given set of words.
Return -1 if not possible to convert.

### Sample input 1:
pit, kate, pat, kit, kat, kite

Convert pit into kite

### Output 1:
2
### Solution: 
pit→kit→kite
### Another possible solution: 
pit → pat →kat→kate→ kite, this yields number of steps as 4 which is not better than the previous solution as we need minimum steps.
