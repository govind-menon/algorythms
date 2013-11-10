Algo-rhythms
==========

This project aims to compare the Lempel Ziv Welch (LZW) and Huffman coding text compression algorithms for inputs based on the parameter of repeated words or sub-strings.
 
We claim that for inputs with a high 'wordiness' parameter i.e where there are a large number of repeated sub-strings LZW will perform much better than Huffman as each of these words would be replaced by the dictionary index resulting in better compression.
 
Conversely inputs with a low 'wordiness' parameter i.e where there are less repeated sub-strings Huffman will give better results.
 
Performance measure of the algorithms will be based on the percentage of compression achieved.
 
We will compare these for the following type of inputs
 
1) Natural text - something like the enwik8 or a common novel.
 
a) Large inputs

b) Small inputs
 
2) Artificial/Synthetic text
 
a) Text with a high wordiness parameter ( different sets of text with these parameter)

b) Text with a low wordiness parameter ( different sets of text with this parameter)
 
We will plot the following-
 
a) LZW performance for a certain input size and the different values of the parameter

b) Huffman performance for a certain input size and the different values of the parameter

c) Compare both for different values of the parameter
 
We will implement both algorithms in that we will be able to apply them to some input text,obtain a compressed output text and that the transformation is reversible - i.e we can successfully obtain the original input text by decompressing the output text.