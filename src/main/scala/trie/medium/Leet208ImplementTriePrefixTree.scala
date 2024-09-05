package trie.medium

import trie.TrieNode

object Leet208ImplementTriePrefixTree {
  class Trie() {

    val trie = new TrieNode

    def insert(word: String): Unit = {

      var node = trie
      for (character <- word) {
        val idx = character - 'a'
        if (node.children(idx) == null) node.children(idx) = new TrieNode
        node = node.children(idx)
      }
      node.isEnd = true
    }

    def search(word: String): Boolean = {
      searchHelper(0, word, trie)
    }

    private def searchHelper(idx: Int, word: String, trieNode: TrieNode): Boolean = {
      if (idx == word.length) trieNode.isEnd
      else {
        val i = word.charAt(idx) - 'a'
        if (trieNode.children(i) == null) false
        else searchHelper(idx + 1, word, trieNode.children(i))
      }
    }


    private def prefixSearchHelper(idx: Int, prefix: String, trieNode: TrieNode): Boolean = {
      if (idx == prefix.length) true
      else {
        val i = prefix.charAt(idx) - 'a'
        if (trieNode.children(i) == null) false
        else prefixSearchHelper(idx + 1, prefix, trieNode.children(i))
      }
    }

    def startsWith(prefix: String): Boolean = {
      prefixSearchHelper(0, prefix, trie)
    }

  }



}
