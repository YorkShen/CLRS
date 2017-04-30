def merge_sort(src):
    """
    :type src: List(int)
    :rtype: None
    """
    if src:
        return __helper(src, 0, len(src))
    else:
        return None


def __helper(src, lo, hi):
    if lo + 1 >= hi:
        return src[lo:hi]
    else:
        mid = (lo + hi) / 2
        left = __helper(src, lo, mid)
        right = __helper(src, mid, hi)
        ret = []
        l_p = r_p = 0
        while l_p < len(left) and r_p < len(right):
            if left[l_p] < right[r_p]:
                ret.append(left[l_p])
                l_p += 1
            else:
                ret.append(right[r_p])
                r_p += 1
        if l_p != len(left):
            ret.extend(left[l_p:])
        elif r_p != len(right):
            ret.extend(right[r_p:])
        return ret
