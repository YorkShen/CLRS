def insert_sort(src):
    """
    :type src: List(int)
    :rtype: None
    """
    for i in xrange(1, len(src)):
        for j in xrange(i - 1, -1, -1):
            if src[j] > src[j + 1]:
                src[j], src[j + 1] = src[j + 1], src[j]
            else:
                break
