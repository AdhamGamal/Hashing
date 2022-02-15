# Hashing
Questions about hashing (<5 min):
- Q1. What is hashing?
- Q2. What problem does hashing try to solve?
- Q3. What is a collision?
- Q4. What is a message? Digest? Checksum? Should two similar messages result in similar digest?
- Q5. What does deterministic mean?
- Q6. Must hashing functions be deterministic?
- Q7. Should it be easy/feasible to recover the original message?
- Q8. Why use a salt in hashing?
- Q9. Why or when should you use a hash that is not strong enough for cryptography?

---

GOAL: create a data structure with 3 properties
1) constant memory
2) false positive (FP) are ok
2) false negative (FN) never ok

---

YOUR CODING CHALLENGE:
1) Modify main.py to print a summary like a sample below
2) Implement methods `test` and `add` in forbiddenfilter.py
3) Don't starve and consistently eat at least 10 out of 11 vegan food 😅

---

SAMPLE OUTPUT:
Net result: 
- you ate 8 vegan food
- incorrectly rejected 3 vegan food
- correctly rejected 6 non vegan food
