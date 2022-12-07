# Collections Framework

> - 컬렉션(Collections) : 여러 객체(데이터)를 모아 놓은 것.
> - 프레임웍(Framework) : 라이브러리(기능) + 프로그래밍 방식을 표준화, 정형화.
> - 컬렉션 프레임웍(Collections Framework) : 여러 객체를 다루기 위한 표준화된 프로그래밍 방식.

> - 컬렉션 프레임웍의 핵심 인터페이스(컬렉션을 3종류로 구분한 것).
> - Collection : List와 Set의 공통 부분으로 만든 인터페이스. List와 Set의 조상 인터페이스.
>
> |   | 저장 순서 | 중복 허용 | EX |
> |:---:|:---:|:---:|:---:|
> | List | o | o | 대기자 명단 |
> | Set | x | x | 동물의 집합 |
> | Map | x | key : x / value : o | ID, PASSWORD |

___

> ## ArrayList
> 
> > | 생성자 |
> > |:----:|
> > | ArrayList() |
> > | ArrayList(Collection c) |
> > | ArrayList(int initialCapacity) |
>
> > | 추가 |
> > |:----:|
> > | boolean add(Object o) |
> > | void add(int index, Object element) |
> > | boolean addAll(Collection c) |
> > | boolean addAll(int index, Collection c) |
>
> > | 삭제 |
> > |:----:|
> > | boolean remove(Object o) |
> > | Object remove(int index) |
> > | boolean removeAll(Collection c) |
> > | void clear() |
> 
> > | 검색 |
> > |:----:|
> > | int indexOf(Object o) |
> > | int lastIndexOf(Object o) |
> > | boolean contains(Object o) |
> > | Object get(int index) |
> > | Object set(int index, Object element) |
> 
> > | 변환 |
> > |:----:|
> > | List subList(int fromIndex, int toIndex) |
> > | Object[] toArray() |
> > | Object[] toArray(Object[] a) |
> > | boolean isEmpty() |
> > | void trimToSize() |
> > | int size() |

___

> ## Stack
> 
> > | 메서드 |
> > |:----:|
> > | boolean empty() |
> > | Object peek() |
> > | Object pop() |
> > | Object push(Object item) |
> > | int search(Object o) |
  
> ## Queue
> 
> > | 메서드 |
> > |:----:|
> > | boolean add(Object o) |
> > | Object remove() |
> > | Object element() |
> > | boolean offer(Object o) |
> > | Object poll() |
> > | Object peek() |

___

> ## Iterator - 컬렉션에 저장된 데이터를 접근하는데(읽어오는데) 사용되는 인터페이스.
> 
> > | 메서드 | 특징 |
> > |:----:|:----:|
> > | boolean hasNext() | 읽어 올 요소가 남아있는지 확인 |
> > | Object next() | 다음 요소를 읽어 옴 |