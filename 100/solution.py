def three_n_plus_one(n, mem):
    length = 1
    while True:
        if n == 1:
            break
        if n % 2 != 0:
            n = 3 * n + 1
        else:
            n = n / 2
        if mem.get(n, None):
            return length + mem[n]
        else:
            length = length + 1
    return length


if __name__ == '__main__':
    mem = {}
    while True:
        try:
            line = input()
            i, j = map(int, line.split())
            ii, jj = min(i, j), max(i, j)
            all_lengths = set()
            for k in range(ii, jj + 1):
                cycle_length = three_n_plus_one(k, mem)
                mem[k] = cycle_length
                all_lengths.add(cycle_length)
            print("{} {} {}".format(i, j, max(all_lengths)))
        except EOFError:
            break

