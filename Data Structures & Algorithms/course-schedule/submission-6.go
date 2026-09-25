func canFinish(n int, req [][]int) bool {
    adj := make([][]int, n)

    for _, pre := range req{
        course, prereq := pre[0], pre[1]
        adj[course] = append(adj[course], prereq)
    }

    state := make([]int, n)
    var hasCycle func(curr int) bool
    hasCycle = func(curr int) bool{
        if state[curr] == 1{
            return true
        }

        if state[curr] == 2{
            return false
        }

        state[curr] = 1

        for _, neighbor := range adj[curr]{
            if hasCycle(neighbor){
                return true
            }
        }

        state[curr] = 2
        return false
    }

    for i := 0; i < n; i++ {
        if state[i] == 0{
            if hasCycle(i){
                return false
            }
        }
    }

    return true
}
