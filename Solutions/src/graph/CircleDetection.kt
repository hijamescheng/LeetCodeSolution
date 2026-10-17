package graph

// This works for an undirected graph only
// Time & space O(V + E)
fun hasCycle(current: Int, visited: BooleanArray, parent: Int, adj: List<List<Int>>): Boolean {
    visited[current] = true
    for (neighbor in adj[current]) {
        if (!visited[neighbor]) {
            if (hasCycle(neighbor, visited, current, adj)) return true
        } else if (neighbor != parent) {
            return true
        }
    }
    return false
}

/**
 * The below solution works on a directed graph only
 * Time & space O(V + E)
 */
fun containsCycle(adj: List<List<Int>>): Boolean {
    val state = IntArray(adj.size)

    for (node in adj.indices) {
        if (state[node] == 0) {
            if (hasCycle(node, state, adj)) {
                return true
            }
        }
    }

    return false
}

fun hasCycle(current: Int, state: IntArray, adj: List<List<Int>>): Boolean {

    // 1 = currently visiting
    if (state[current] == 1) return true

    // 2 = already fully explored
    if (state[current] == 2) return false

    state[current] = 1

    for (neighbor in adj[current]) {
        if (hasCycle(neighbor, state, adj)) {
            return true
        }
    }

    state[current] = 2

    return false
}