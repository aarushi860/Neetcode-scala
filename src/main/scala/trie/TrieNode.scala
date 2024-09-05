package trie

class TrieNode {
  val children = new Array[TrieNode](26)
  var isEnd = false
}