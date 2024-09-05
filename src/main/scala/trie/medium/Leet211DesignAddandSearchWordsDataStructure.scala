package trie.medium

import trie.TrieNode

object Leet211DesignAddandSearchWordsDataStructure {
  class WordDictionary() {

    val trie = new TrieNode

    def addWord(word: String): Unit = {
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
        val character = word.charAt(idx)
        if (character == '.') trieNode.children.filterNot(_==null).exists(child => searchHelper(idx + 1, word, child))
        else {
          val i = character - 'a'
          if (trieNode.children(i) == null) false
          else searchHelper(idx + 1, word, trieNode.children(i))
        }
      }
    }

  }


}
